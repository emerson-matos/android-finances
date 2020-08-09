package com.github.emerson.financas.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class CardDTO(
    @SerializedName("client") val client: String = "",
    @SerializedName("id") val id: UUID = UUID.fromString("null"),
    @SerializedName("institution") val institution: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("number") val number: String = ""
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val cardDTO = other as CardDTO
        return client == cardDTO.client &&
                id == cardDTO.id &&
                institution == cardDTO.institution &&
                name == cardDTO.name &&
                number == cardDTO.number
    }

    override fun hashCode(): Int {
        return Objects.hash(client, id, institution, name, number)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class CardDTO {\n")
        sb.append("    client: ").append(toIndentedString(client)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    institution: ").append(toIndentedString(institution)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    number: ").append(toIndentedString(number)).append("\n")
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