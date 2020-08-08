package com.github.emerson.financas.data.repository.expense

import com.github.emerson.financas.data.model.ExpenseData

interface ExpenseRepository {
    suspend fun doRequestExpenseList(): List<ExpenseData>

    suspend fun doRequestExpense(): ExpenseData
}
