package br.com.controle.financas.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import br.com.controle.financas.R
import br.com.controle.financas.ui.main.expense.ExpenseActivity
import kotlinx.android.synthetic.main.welcome_card.*

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
        card_resume.setOnClickListener {
            val intent = Intent(this.context, ExpenseActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(
                R.anim.screen_enter_from_right,
                R.anim.screen_exit_from_left
            )
        }
    }

}