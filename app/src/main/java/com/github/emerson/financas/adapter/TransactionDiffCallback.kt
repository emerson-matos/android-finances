package com.github.emerson.financas.adapter

import androidx.recyclerview.widget.DiffUtil
import com.github.emerson.financas.data.model.TransactionDTO

class TransactionDiffCallback : DiffUtil.ItemCallback<TransactionDTO> () {
    override fun areItemsTheSame(oldItem: TransactionDTO, newItem: TransactionDTO): Boolean {
        //TODO TransactionDTO.equals()
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TransactionDTO, newItem: TransactionDTO): Boolean {
        //TODO ExpendaData.hashCode()
        return oldItem.account == newItem.account && oldItem.value == newItem.value
    }

}