package br.com.controle.financas.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.controle.financas.data.model.ExpenseData

class ExpenseDiffCallback : DiffUtil.ItemCallback<ExpenseData> () {
    override fun areItemsTheSame(oldItem: ExpenseData, newItem: ExpenseData): Boolean {
        //TODO ExpenseData.equals()
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ExpenseData, newItem: ExpenseData): Boolean {
        //TODO ExpendaData.hashCode()
        return oldItem.accountId == newItem.accountId && oldItem.value == newItem.value
    }

}