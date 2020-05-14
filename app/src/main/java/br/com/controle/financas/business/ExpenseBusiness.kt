package br.com.controle.financas.business

import br.com.controle.financas.data.model.ExpenseData
import br.com.controle.financas.data.repository.expense.ExpenseRepository

class ExpenseBusiness(private val expenseRespository: ExpenseRepository) {

    suspend fun fetchExpenseList(): List<ExpenseData> = expenseRespository.doRequestExpenseList()
}
