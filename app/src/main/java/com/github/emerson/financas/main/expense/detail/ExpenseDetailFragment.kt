package com.github.emerson.financas.main.expense.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.github.emerson.financas.R
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
        val itemId: Long? = (activity?.intent?.extras?.get("item") as Bundle).get("item") as Long?
        (requireActivity() as AppCompatActivity).setSupportActionBar(expenseDetailToolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        viewModel.getExpense(itemId)

        configureViewModel()
    }

    private fun configureViewModel() {
        viewModel.item.observe(viewLifecycleOwner, {
            requireActivity().title = it.name
            expenseDetailDescription.text = it.description
            expenseDetailCurrency.text = it.currency.toString()
            expenseDetailDate.text = it.formatedDate()
            expenseDetailValue.text = it.formatedValue()
            expenseDetailOwner.text = it.ownerId.toString()
            expenseDetailCard.text = it.cardId.toString()
            expenseDetailAccount.text = it.accountId.toString()
        })

        viewModel.accountVisibility.observe(viewLifecycleOwner, {
            when (it) {
                true -> {
                    expenseDetailAccount.visibility = View.VISIBLE
                    expenseDetailAccountLabel.visibility = View.VISIBLE
                }
                false -> {
                    expenseDetailAccount.visibility = View.GONE
                    expenseDetailAccountLabel.visibility = View.GONE
                }
            }
        })

        viewModel.cardVisibility.observe(viewLifecycleOwner, {
            when (it) {
                true -> {
                    expenseDetailCard.visibility = View.VISIBLE
                    expenseDetailCardLabel.visibility = View.VISIBLE
                }
                false -> {
                    expenseDetailCard.visibility = View.GONE
                    expenseDetailCardLabel.visibility = View.GONE
                }
            }
        })

    }

}
