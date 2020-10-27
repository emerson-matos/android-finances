package com.github.emerson.financas.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Currency
import java.util.Locale
import kotlin.random.Random

@Parcelize
data class ExpenseData(
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
) : Parcelable, Comparable<ExpenseData> {
    fun formatedValue(): CharSequence = String.format("%.2f", value)
    fun formatedDate(): CharSequence = SimpleDateFormat("dd/MM/yyyy", Locale("pt-BR")).format(date)

    override fun compareTo(other: ExpenseData): Int {
        val result = this.date.time.minus(other.date.time)
        return when {
            result > 0 -> {
                -1
            }
            result < 0 -> {
                1
            }
            else -> 0
        }
    }
}