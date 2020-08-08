package com.github.emerson.financas.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.emerson.financas.R
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.github.emerson.financas.main.expense.ExpenseActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
        welcomeCard.setOnClickListener {
            val intent = Intent(this.context, ExpenseActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(
                R.anim.screen_enter_from_right,
                R.anim.screen_exit_from_left
            )
        }
        val endpoint = RetrofitConfiguration.getRetrofitInstance().create(API::class.java)
        fetchData(endpoint)


    }

    private fun fetchData(endpoint: API) {
        FirebaseAuth.getInstance()//
            .currentUser?.getIdToken(true)//
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val idToken = task.result?.token
                    val callback = idToken?.let { endpoint.getClients(it) }
                    println("meu token \n$idToken")
                    textView.text.append("$idToken\n")
                    callback?.enqueue(object :
                        Callback<Map<String, Map<String, Any>>> {
                        override fun onFailure(
                            call: Call<Map<String, Map<String, Any>>>,
                            t: Throwable
                        ) {
                            println("errorrrrrrrrrrrrr")
                            Toast.makeText(
                                this@HomeFragment.activity?.baseContext,
                                t.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        override fun onResponse(
                            call: Call<Map<String, Map<String, Any>>>,
                            response: Response<Map<String, Map<String, Any>>>
                        ) {
                            (response.body()?.get("_embedded")
                                ?.get("clientDTOList") as List<Map<String, Any>>).forEach {
                                textView.text.appendln("${it["name"]}\n")
                            }
                            println(response.body()?.get("_embedded")?.get("clientDTOList"))
                        }
                    })
                } else {
                    Toast.makeText(
                        this@HomeFragment.activity?.baseContext,
                        "somenthing when wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}