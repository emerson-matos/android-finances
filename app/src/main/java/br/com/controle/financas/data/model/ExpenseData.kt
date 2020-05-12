package br.com.controle.financas.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

class ExpenseData(@SerializedName("expenseId") val id: Long = -1L,
                  @SerializedName("name") val name: String = "23",
                  @SerializedName("description") val description: String = "23",
                  @SerializedName("trasactionDate") val date: Date = Date(),
                  @SerializedName("value") val value: BigDecimal = BigDecimal.ZERO,
                  @SerializedName("ownerId") val ownerId: Long = -1L,
                  @SerializedName("accountId") val accountId: Long = -1L,
                  @SerializedName("cardId") val cardId: Long = -1L)