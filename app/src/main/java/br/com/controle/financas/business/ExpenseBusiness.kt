package br.com.controle.financas.business

import br.com.controle.financas.data.model.ExpenseData
import br.com.controle.financas.data.repository.expense.ExpenseRepository
import br.com.controle.financas.data.repository.expense.ExpenseRepositoryImpl

class ExpenseBusiness(private val expenseRespository: ExpenseRepository = ExpenseRepositoryImpl()) {

    suspend fun fetchExpenseList(): List<ExpenseData> = expenseRespository.doRequestExpenseList()

    suspend fun fetchExpense(): ExpenseData = expenseRespository.doRequestExpense()
}
