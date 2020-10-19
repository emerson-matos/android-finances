package com.github.emerson.financas.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.emerson.financas.R
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.github.emerson.financas.main.expense.list.ExpenseListActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        welcomeCard.setOnClickListener {
            val intent = Intent(this.context, ExpenseListActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(
                R.anim.screen_enter_from_right,
                R.anim.screen_exit_from_left
            )
        }
        viewModel.loadToken()
        configureViewModel()
    }

    private fun configureViewModel() {
        viewModel.token.observe(viewLifecycleOwner, {
            textView.text.appendLine(it)
        })

        viewModel.error.observe(viewLifecycleOwner, {
            textView.text.clear()
        })
    }

}