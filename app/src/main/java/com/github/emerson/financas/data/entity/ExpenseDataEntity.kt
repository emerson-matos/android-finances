package com.github.emerson.financas.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.Date
import java.util.Currency

@Entity(tableName =  "expense_data_table")
data class ExpenseDataEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String,
//    val date: Date,
//    val currency: Currency,
//    val value: BigDecimal,
    val ownerId: Long,
    val accountId: Long,
    val cardId: Long
)