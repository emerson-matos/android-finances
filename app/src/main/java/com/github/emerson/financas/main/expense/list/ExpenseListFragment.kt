package com.github.emerson.financas.main.expense.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.emerson.financas.R
import com.github.emerson.financas.adapter.EndlessRecyclerViewScrollListener
import com.github.emerson.financas.adapter.ExpenseAdapter
import kotlinx.android.synthetic.main.expense_list.*
import kotlinx.android.synthetic.main.expense_list_fragment.*

class ExpenseListFragment : Fragment() {

    companion object {
        fun newInstance() =
            ExpenseListFragment()
    }

    private val listViewModel: ExpenseListViewModel by viewModels()
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.expense_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(ExpenseViewModel::class.java)
        adapter = ExpenseAdapter(listViewModel, requireActivity())
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
            listViewModel.fetchMoreData()
        }

        addExpenseButton.setOnClickListener {
            Toast.makeText(this.context, "add expense click", Toast.LENGTH_LONG).show()
        }

        configureViewModel()
    }


    private fun configureViewModel() {
        listViewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("LOADING VALUE $it")
                expenseSwipeRefreshLayout.isRefreshing = it
            }
        })

        listViewModel.states.observe(viewLifecycleOwner, Observer {
            it?.let {
                println("list size ${it.size} in ${System.currentTimeMillis()}")
                this.adapter.updateData(it)
            }
        })
    }

}
