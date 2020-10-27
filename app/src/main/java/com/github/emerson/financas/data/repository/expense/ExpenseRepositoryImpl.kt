package com.github.emerson.financas.data.repository.expense

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.emerson.financas.data.entity.ExpenseDataEntity
import com.github.emerson.financas.data.model.ExpenseData
import java.math.BigDecimal
import kotlin.random.Random

class ExpenseRepositoryImpl(
    private val endpoint: API,
    private val expenseDAO: ExpenseDAO
) : ExpenseRepository {

    val allExpenses: LiveData<List<ExpenseDataEntity>> = expenseDAO.getExpensesLiveData()

    override suspend fun doRequestExpenseList(): List<ExpenseData> =//        listOf(
//            ExpenseData(id = 1, name = "Bday"),
//            ExpenseData(id = 2, name = "Bday2"),
//            ExpenseData(id = 3, name = "Bday3"),
//            ExpenseData(id = 4, name = "Bday4"),
//            ExpenseData(id = 5, name = "Bday5"),
//            ExpenseData(id = 6, name = "Bday6"),
//            ExpenseData(id = 7, name = "Bday7"),
//            ExpenseData(id = 8, name = "Bday8"),
//            ExpenseData(id = 9, name = "Bday9"),
//            ExpenseData(value = BigDecimal.valueOf(2)),
//            ExpenseData(
//                name = "Class",
//                value = BigDecimal.valueOf(123.32)
//            ),
//            ExpenseData(name = "Soda"),
//            ExpenseData(name = "Pizza")
//        )
        expenseDAO.getExpenses().map {
            ExpenseData(
                it.id,
                it.name,
                it.description,
                //                it.date,
                //                it.currency,
                //                it.value,
                ownerId = it.ownerId,
                accountId = it.accountId,
                cardId = it.cardId
            )
        }

    override suspend fun doRequestExpense(): ExpenseData =
        when {
            Random.nextLong(0, 3).rem(3) == 0L -> throw IllegalStateException()
            else ->
                ExpenseData(
                    id = Random.nextLong(0, 100_000),
                    description = "Vacation",
                    value = BigDecimal.valueOf(Random.nextLong(0, 100_000)),
                    ownerId = Random.nextLong(0, 100_000),
                    accountId = Random.nextLong(0, 100_000),
                    cardId = Random.nextLong(0, 100_000),
                )
        }

    override suspend fun doCreateExpense(expense: ExpenseData) {
        expense.let {
            expenseDAO.insert(
                ExpenseDataEntity(
                    it.id,
                    it.name,
                    it.description,
                    it.ownerId,
                    it.accountId,
                    it.cardId
                )
            )
        }
    }
}

@Dao
interface ExpenseDAO {
    @Query("SELECT * from expense_data_table ORDER BY id ASC")
    fun getExpenses(): List<ExpenseDataEntity>

    @Query("SELECT * from expense_data_table ORDER BY id ASC")
    fun getExpensesLiveData(): LiveData<List<ExpenseDataEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: ExpenseDataEntity)

    @Query("DELETE FROM expense_data_table")
    suspend fun deleteAll()
}