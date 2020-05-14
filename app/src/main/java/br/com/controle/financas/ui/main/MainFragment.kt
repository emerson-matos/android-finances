package br.com.controle.financas.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.controle.financas.R
import br.com.controle.financas.adapter.ExpenseAdapter
import br.com.controle.financas.data.model.ExpenseData
import kotlinx.android.synthetic.main.expense_list.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val list: MutableList<ExpenseData> = mutableListOf()
    private lateinit var viewModel: ExpenseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpenseViewModel::class.java)
        expenseList.apply {
            adapter = ExpenseAdapter(viewModel, list)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        configureViewModel()
        viewModel.fetchData()
    }

    private fun configureViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("LOADING VALUE ${it}")
                expenseLoading.visibility = if(it) View.VISIBLE else View.GONE
                expenseList.visibility = if(it) View.GONE else View.VISIBLE
            }
        })

        viewModel.states.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("list size ${it.size}")
                list.clear()
                list.addAll(it)
            }
        })
    }

}