package com.github.emerson.financas.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal
import java.text.SimpleDateFormat
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString() ?: "error",
        parcel.readString() ?: "error",
        Date(parcel.readLong()),
        Currency.getInstance(parcel.readString()),
        BigDecimal(parcel.readString()),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong()
    ) {
    }

    fun formatedValue(): CharSequence = String.format("%.2f", value)
    fun formatedDate(): CharSequence = SimpleDateFormat("dd/MM/yyyy", Locale("pt-BR")).format(date)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeLong(date.time)
        parcel.writeString(currency.currencyCode)
        parcel.writeString(value.toString())
        parcel.writeLong(ownerId)
        parcel.writeLong(accountId)
        parcel.writeLong(cardId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExpenseData> {
        override fun createFromParcel(parcel: Parcel): ExpenseData {
            return ExpenseData(parcel)
        }

        override fun newArray(size: Int): Array<ExpenseData?> {
            return arrayOfNulls(size)
        }
    }
}