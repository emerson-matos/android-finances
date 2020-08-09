package com.github.emerson.financas.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.emerson.financas.R
import com.github.emerson.financas.data.model.TransactionDTO
import com.github.emerson.financas.main.expense.ExpenseActivity
import com.github.emerson.financas.main.expense.list.ExpenseViewModel
import kotlinx.android.synthetic.main.item_list_expense.view.*
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(private val viewModel: ExpenseViewModel) :
    ListAdapter<TransactionDTO, ExpenseAdapter.ExpenseViewHolder>(TransactionDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateData(data: List<TransactionDTO>?) {
        data?.let {
            submitList(it)
        }
        return
    }

    fun addMore() {
        viewModel.fetchMoreData()
    }

    class ExpenseViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: TransactionDTO) {
            view.apply {
                expenseDate.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt-BR")).format(item.date)
                expenseName.text = item.name
                expenseValue.text = String.format("%.2f", item.value)
                expenseCurrency.text = item.currency
                setOnClickListener {
                    Toast.makeText(this.context, "expense detail", Toast.LENGTH_LONG).show()
                    val intent = Intent(context, ExpenseActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}