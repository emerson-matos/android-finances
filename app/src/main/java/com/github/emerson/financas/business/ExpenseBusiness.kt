package com.github.emerson.financas.business

import com.github.emerson.financas.data.model.ExpenseData
import com.github.emerson.financas.data.repository.expense.ExpenseRepository

class ExpenseBusiness(private val expenseRespository: ExpenseRepository) {

    suspend fun fetchExpenseList(): List<ExpenseData> = expenseRespository.doRequestExpenseList()

    suspend fun fetchExpense(): ExpenseData = expenseRespository.doRequestExpense()

    suspend fun save(value: ExpenseData) = expenseRespository.doCreateExpense(value)
}
