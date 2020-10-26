package com.github.emerson.financas.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.emerson.financas.R
import com.github.emerson.financas.main.expense.list.ExpenseListActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.welcome_card.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()

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
        welcomeCard.title.text = getString(R.string.welcome_user, FirebaseAuth.getInstance().currentUser?.displayName)
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