package com.github.emerson.financas.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class BankAccountDTO(
    @SerializedName("agency") val agency: String = "",
    @SerializedName("dac") val dac: String = "",
    @SerializedName("id") val id: String = "",
    @SerializedName("institution") val institution: String = "",
    @SerializedName("number") val number: String = "",
    @SerializedName("owner") val owner: String = "",
    @SerializedName("responsible") val responsible: String = ""
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val bankAccountDTO = other as BankAccountDTO
        return agency == bankAccountDTO.agency &&
                dac == bankAccountDTO.dac &&
                id == bankAccountDTO.id &&
                institution == bankAccountDTO.institution &&
                number == bankAccountDTO.number &&
                owner == bankAccountDTO.owner &&
                responsible == bankAccountDTO.responsible
    }

    override fun hashCode(): Int {
        return Objects.hash(agency, dac, id, institution, number, owner, responsible)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class BankAccountDTO {\n")
        sb.append("    agency: ").append(toIndentedString(agency)).append("\n")
        sb.append("    dac: ").append(toIndentedString(dac)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    institution: ").append(toIndentedString(institution)).append("\n")
        sb.append("    number: ").append(toIndentedString(number)).append("\n")
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n")
        sb.append("    responsible: ").append(toIndentedString(responsible)).append("\n")
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