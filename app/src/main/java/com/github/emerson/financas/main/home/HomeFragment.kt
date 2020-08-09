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
import com.github.emerson.financas.data.model.resource.ResourcesResourceClientDTO
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.github.emerson.financas.main.expense.ExpenseActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.welcome_card.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var user : FirebaseUser? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        user = FirebaseAuth.getInstance().currentUser
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
        welcomeCard.setOnClickListener {
            val intent = Intent(this.context, ExpenseActivity::class.java)
            startActivity(intent)
            activity?.overridePendingTransition(R.anim.screen_enter_from_right,
                                                R.anim.screen_exit_from_left)
        }

        welcomeCard.title.text = getString(R.string.welcome_tile_user, user?.displayName)
    }

}