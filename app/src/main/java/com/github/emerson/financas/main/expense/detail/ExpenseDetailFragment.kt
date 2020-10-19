package com.github.emerson.financas.main.expense.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.emerson.financas.R
import com.github.emerson.financas.data.model.ExpenseData
import kotlinx.android.synthetic.main.expense_detail_fragment.*

class ExpenseDetailFragment : Fragment() {

    companion object {
        fun newInstance() =
            ExpenseDetailFragment()
    }

    private val viewModel: ExpenseDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.expense_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val item: ExpenseData? = (activity?.intent?.extras?.get("item") as Bundle).get("item") as ExpenseData?
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        item?.let {
            expenseDetailName.text = item.name
            expenseDetailId.text= item.id.toString()
            expenseDetailOwner.text= item.ownerId.toString()
            expenseDetailCard.text= item.cardId.toString()
            expenseDetailAccount.text= item.accountId.toString()
            expenseDetailDescription.text= item.description
            expenseDetailCurrency.text = item.currency.toString()
            expenseDetailDate.text = item.formatedDate()
            expenseDetailValue.text = item.formatedValue()
        }
        collapsing_toolbar.title = item?.name ?: "123123"
        configureViewModel()
    }

    private fun configureViewModel() {
    }

}
