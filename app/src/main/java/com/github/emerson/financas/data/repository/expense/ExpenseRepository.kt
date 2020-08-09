package com.github.emerson.financas.data.repository.expense

import com.github.emerson.financas.data.model.TransactionDTO

interface ExpenseRepository {
    suspend fun doRequestExpenseList(): List<TransactionDTO>

    suspend fun doRequestExpense(): TransactionDTO
}
