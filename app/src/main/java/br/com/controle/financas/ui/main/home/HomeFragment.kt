package br.com.controle.financas.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.controle.financas.R
import br.com.controle.financas.data.model.LoggedUser
import br.com.controle.financas.data.repository.expense.API
import br.com.controle.financas.infrastructure.RetrofitConfiguration
import br.com.controle.financas.ui.main.expense.ExpenseActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.welcome_card.*
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
        // TODO: NULLPOINTER set on clicklistener
//        card_resume.setOnClickListener {
//            val intent = Intent(this.context, ExpenseActivity::class.java)
//            startActivity(intent)
//            activity?.overridePendingTransition(
//                R.anim.screen_enter_from_right,
//                R.anim.screen_exit_from_left
//            )
//        }
        val endpoint = RetrofitConfiguration.getRetrofitInstance().create(API::class.java)
        FirebaseAuth.getInstance().currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val idToken = task.result?.token
                val callback = idToken?.let { endpoint.getClients(it) }
                print("meu token $idToken meu TOKEN")
                textView.text = "$idToken\n"
                callback?.enqueue(object :
                    Callback<List<LoggedUser>> {
                    override fun onFailure(call: Call<List<LoggedUser>>, t: Throwable) {
                        Toast.makeText(this@HomeFragment.activity?.baseContext, t.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<List<LoggedUser>>, response: Response<List<LoggedUser>>) {
                        response.body()?.forEach {
                            textView.text = textView.text.toString().plus("${it.name}\n")
                        }
                    }
                })
            } else {
                Toast.makeText(this@HomeFragment.activity?.baseContext, "DEU RUIM  NO TOKEN", Toast.LENGTH_SHORT).show()
            }
        }


    }

}