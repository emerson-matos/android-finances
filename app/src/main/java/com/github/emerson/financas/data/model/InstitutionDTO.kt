package com.github.emerson.financas.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class InstitutionDTO(
    @SerializedName("id") val id: String = "",
    @SerializedName("identifier") val identifier: String = "",
    @SerializedName("name") val name: String = ""
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val institutionDTO = other as InstitutionDTO
        return id == institutionDTO.id && identifier == institutionDTO.identifier && name == institutionDTO.name
    }

    override fun hashCode(): Int {
        return Objects.hash(id, identifier, name)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class InstitutionDTO {\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
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