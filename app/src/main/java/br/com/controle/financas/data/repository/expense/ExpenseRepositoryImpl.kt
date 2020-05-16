package br.com.controle.financas.data.repository.expense

import br.com.controle.financas.data.model.ExpenseData
import java.math.BigDecimal
import java.util.*

class ExpenseRepositoryImpl: ExpenseRepository {
    override suspend fun doRequestExpenseList(): List<ExpenseData> = listOf(
        ExpenseData(),
        ExpenseData(value = BigDecimal.valueOf(2)),
        ExpenseData(
            name = "Curso",
            value = BigDecimal.valueOf(123.32)
        ),
        ExpenseData(name = "Refri"),
        ExpenseData(name = "Pizza")
    )

    override suspend fun doRequestExpense(): ExpenseData =
        ExpenseData(
            description = "vacation",
            value = BigDecimal.valueOf(300)
        )
}
