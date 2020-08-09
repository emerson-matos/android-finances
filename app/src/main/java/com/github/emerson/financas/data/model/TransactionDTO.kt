package com.github.emerson.financas.data.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.*

class TransactionDTO(
    @SerializedName("account") val account: String = "",
    @SerializedName("card") val card: String = "",
    @SerializedName("client") val client: String = "",
    @SerializedName("currency") val currency: String = "",
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("date") val date: Calendar = Calendar.getInstance(),
    @SerializedName("value") val value: BigDecimal = BigDecimal.ZERO
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val transactionDTO = other as TransactionDTO
        return account == transactionDTO.account &&
                card == transactionDTO.card &&
                client == transactionDTO.client &&
                currency == transactionDTO.currency &&
                id == transactionDTO.id &&
                name == transactionDTO.name &&
                date == transactionDTO.date &&
                value == transactionDTO.value
    }

    override fun hashCode(): Int {
        return Objects.hash(
            account,
            card,
            client,
            currency,
            id,
            name,
            date,
            value
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class TransactionDTO {\n")
        sb.append("    account: ").append(toIndentedString(account)).append("\n")
        sb.append("    card: ").append(toIndentedString(card)).append("\n")
        sb.append("    client: ").append(toIndentedString(client)).append("\n")
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    date: ").append(toIndentedString(date)).append("\n")
        sb.append("    value: ").append(toIndentedString(value)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}