package com.github.emerson.financas.data.repository.expense

import com.github.emerson.financas.data.model.ExpenseData
import java.math.BigDecimal

class ExpenseRepositoryImpl: ExpenseRepository {
    override suspend fun doRequestExpenseList(): List<ExpenseData> = listOf(
        ExpenseData(id=1, name = "Bday"),
        ExpenseData(id=2, name = "Bday2"),
        ExpenseData(id=3, name = "Bday3"),
        ExpenseData(id=4, name = "Bday4"),
        ExpenseData(id=5, name = "Bday5"),
        ExpenseData(id=6, name = "Bday6"),
        ExpenseData(id=7, name = "Bday7"),
        ExpenseData(id=8, name = "Bday8"),
        ExpenseData(id=9, name = "Bday9"),
        ExpenseData(value = BigDecimal.valueOf(2)),
        ExpenseData(
            name = "Class",
            value = BigDecimal.valueOf(123.32)
        ),
        ExpenseData(name = "Soda"),
        ExpenseData(name = "Pizza")
    )

    override suspend fun doRequestExpense(): ExpenseData =
        ExpenseData(
            description = "Vacation",
            value = BigDecimal.valueOf(300)
        )
}
