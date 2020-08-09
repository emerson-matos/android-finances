package com.github.emerson.financas.business

import com.github.emerson.financas.data.model.TransactionDTO
import com.github.emerson.financas.data.repository.expense.ExpenseRepository
import com.github.emerson.financas.data.repository.expense.ExpenseRepositoryImpl

class ExpenseBusiness(private val expenseRespository: ExpenseRepository = ExpenseRepositoryImpl()) {

    suspend fun fetchExpenseList(): List<TransactionDTO> = expenseRespository.doRequestExpenseList()

    suspend fun fetchExpense(): TransactionDTO = expenseRespository.doRequestExpense()
}
