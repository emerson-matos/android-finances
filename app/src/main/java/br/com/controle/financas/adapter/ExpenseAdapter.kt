package br.com.controle.financas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.controle.financas.R
import br.com.controle.financas.data.model.ExpenseData
import br.com.controle.financas.ui.main.MainViewModel
import kotlinx.android.synthetic.main.item_list_expense.view.*
import java.lang.String.format
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(private val viewModel: MainViewModel,
                     private val list: List<ExpenseData>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_expense, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(item: ExpenseData) {
            view.apply {
                expenseDate.text = SimpleDateFormat("dd/MM/yyyy", Locale("pt-BR")).format(item.date)
                expenseName.text = item.name
                expenseValue.text = item.value.toString()
            }
        }
    }
}