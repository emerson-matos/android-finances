package com.github.emerson.financas.data.repository.expense

import com.github.emerson.financas.data.model.TransactionDTO
import java.math.BigDecimal

class ExpenseRepositoryImpl: ExpenseRepository {
    override suspend fun doRequestExpenseList(): List<TransactionDTO> = listOf(
        TransactionDTO(),
        TransactionDTO(value = BigDecimal.valueOf(2)),
        TransactionDTO(
            name = "Curso",
            value = BigDecimal.valueOf(123.32)
        ),
        TransactionDTO(name = "Refri"),
        TransactionDTO(name = "Pizza")
    )

    override suspend fun doRequestExpense(): TransactionDTO =
        TransactionDTO(
            value = BigDecimal.valueOf(300)
        )
}
