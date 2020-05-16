package br.com.controle.financas.ui.main.expense.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.controle.financas.R
import br.com.controle.financas.adapter.EndlessRecyclerViewScrollListener
import br.com.controle.financas.adapter.ExpenseAdapter
import kotlinx.android.synthetic.main.expense_list.*
import kotlinx.android.synthetic.main.expense_list_fragment.*

class ExpenseListFragment : Fragment() {

    companion object {
        fun newInstance() =
            ExpenseListFragment()
    }

    private lateinit var viewModel: ExpenseViewModel
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.expense_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpenseViewModel::class.java)
        adapter = ExpenseAdapter(viewModel)
        expenseList.apply {
            adapter = this@ExpenseListFragment.adapter
            layoutManager = LinearLayoutManager(context)
            addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(this.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
//                    viewModel.fetchMoreData()
                }
            })
        }

        expenseSwipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchMoreData()
        }

        addExpenseButton.setOnClickListener {
            Toast.makeText(this.context, "add expense click", Toast.LENGTH_LONG).show()
        }

        configureViewModel()
    }


    private fun configureViewModel() {
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("LOADING VALUE $it")
                expenseSwipeRefreshLayout.isRefreshing = it
            }
        })

        viewModel.states.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("list size ${it.size} in ${System.currentTimeMillis()}")
                this.adapter.updateData(it)
            }
        })
    }

}
