package br.com.controle.financas.data.repository.expense

import br.com.controle.financas.data.model.ExpenseData

interface ExpenseRepository {
    suspend fun doRequestExpenseList(): List<ExpenseData>

}
