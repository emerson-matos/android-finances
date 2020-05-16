package br.com.controle.financas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.controle.financas.R
import br.com.controle.financas.data.model.ExpenseData
import br.com.controle.financas.ui.main.ExpenseViewModel
import kotlinx.android.synthetic.main.item_list_expense.view.*
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(private val viewModel: ExpenseViewModel) :
    ListAdapter<ExpenseData, ExpenseAdapter.ExpenseViewHolder>(ExpenseDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateData(data: List<ExpenseData>?) {
        data?.let {
            submitList(it)
        }
        return
    }

    fun addMore() {
        viewModel.fetchMoreData()
    }

    class ExpenseViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ExpenseData) {
            view.apply {
                expenseDate.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt-BR")).format(item.date)
                expenseName.text = item.name
                expenseValue.text = String.format("%.2f", item.value)
            }
        }
    }
}