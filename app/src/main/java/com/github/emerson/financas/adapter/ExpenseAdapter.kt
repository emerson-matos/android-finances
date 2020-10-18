package com.github.emerson.financas.adapter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.emerson.financas.R
import com.github.emerson.financas.data.model.ExpenseData
import com.github.emerson.financas.main.expense.detail.ExpenseDetailActivity
import com.github.emerson.financas.main.expense.list.ExpenseListViewModel
import kotlinx.android.synthetic.main.item_list_expense.view.*

class ExpenseAdapter(private val listViewModel: ExpenseListViewModel, private val activity: Activity) :
    ListAdapter<ExpenseData, ExpenseAdapter.ExpenseViewHolder>(ExpenseDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_list_expense,
            parent,
            false
        )
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position), activity)
    }

    fun updateData(data: List<ExpenseData>?) {
        data?.let {
            submitList(it)
        }
        return
    }

    fun addMore() {
        listViewModel.fetchMoreData()
    }

    class ExpenseViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ExpenseData, activity: Activity) {
            view.apply {
                expenseDate.text = item.formatedDate()
                expenseName.text = item.name
                expenseValue.text = item.formatedValue()
                expenseCurrency.text = item.currency.toString()
                setOnClickListener {
                    Toast.makeText(this.context, "expense detail", Toast.LENGTH_LONG).show()
                    val intent = Intent(this.context, ExpenseDetailActivity::class.java)
                    val bundle = Bundle()
                    bundle.putParcelable("item", item)
                    intent.putExtra("item", bundle)
                    startActivity(context, intent, bundle)
                    activity.overridePendingTransition(
                        R.anim.screen_enter_from_right,
                        R.anim.screen_exit_from_left
                    )
                }
            }
        }
    }
}