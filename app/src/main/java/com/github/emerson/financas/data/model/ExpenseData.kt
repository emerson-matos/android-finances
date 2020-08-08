package com.github.emerson.financas.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*
import kotlin.random.Random

class ExpenseData(
    @SerializedName("expenseId") val id: Long = -1L,
    @SerializedName("name") val name: String = "23",
    @SerializedName("description") val description: String = "23",
    @SerializedName("transactionDate") val date: Date = Date(
        Random.nextLong(
            0,
            System.currentTimeMillis()
        )
    ),
    @SerializedName("currency") val currency: Currency = Currency.getInstance("BRL"),
    @SerializedName("value") val value: BigDecimal = BigDecimal.valueOf(
        Random.nextDouble(
            0.0,
            1000.00
        )
    ),
    @SerializedName("ownerId") val ownerId: Long = -1L,
    @SerializedName("accountId") val accountId: Long = -1L,
    @SerializedName("cardId") val cardId: Long = -1L
)