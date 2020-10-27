package com.github.emerson.financas.main.expense.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.emerson.financas.R
import com.github.emerson.financas.adapter.EndlessRecyclerViewScrollListener
import com.github.emerson.financas.adapter.ExpenseAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.expense_list.*
import kotlinx.android.synthetic.main.expense_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExpenseListFragment : Fragment() {

    companion object {
        fun newInstance() =
            ExpenseListFragment()
    }

    private val listViewModel: ExpenseListViewModel by viewModel()
    private lateinit var adapter: ExpenseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.expense_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ExpenseAdapter(requireActivity())
        expenseList.apply {
            adapter = this@ExpenseListFragment.adapter
            layoutManager = LinearLayoutManager(context)
            addOnScrollListener(object :
                EndlessRecyclerViewScrollListener(this.layoutManager as LinearLayoutManager) {
                override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                    listViewModel.fetchMoreData()
                }
            })
        }

        expenseSwipeRefreshLayout.setOnRefreshListener {
            listViewModel.fetchMoreData()
        }

        addExpenseButton.setOnClickListener {
            Snackbar.make(addExpenseButton, "add expense", Snackbar.LENGTH_SHORT)
                .setAction("retry") {
                    listViewModel.fetchData()
                }
                .show()
        }

        configureViewModel()
    }

    override fun onPause() {
        super.onPause()
        listViewModel.save()
    }

    private fun configureViewModel() {
        listViewModel.loading.observe(viewLifecycleOwner, {
            it?.let {
                println("LOADING VALUE $it")
                expenseSwipeRefreshLayout.isRefreshing = it
            }
        })

        listViewModel.states.observe(viewLifecycleOwner, {
            it?.let {
                val initialTime = System.currentTimeMillis()
                println("Sorting list with size ${it.size} at $initialTime")
                val fetchExpenseList = it.toMutableList()
                synchronized(fetchExpenseList) {
                    fetchExpenseList.sort()
                }
                println("List with size ${it.size} sorted at ${System.currentTimeMillis()}, after ${System.currentTimeMillis() - initialTime}")
                this.adapter.updateData(fetchExpenseList.toList())
            }
        })

        listViewModel.snackbar.observe(viewLifecycleOwner, {
            it?.let {
                when (it) {
                    true -> {
                        Snackbar.make(requireView().findViewById(R.id.addExpenseButton), "Error updating list", Snackbar.LENGTH_SHORT)
                            .setAction("retry") {
                                listViewModel.fetchData()
                            }
                            .show()
                        listViewModel.showSnackbar()
                    }
                }
            }
        })
    }

}