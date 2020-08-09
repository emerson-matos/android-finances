package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import java.util.*

class ResourceCardDTO(@SerializedName("_links") val links: MutableList<Link> = ArrayList(),
                      @SerializedName("client") val client: String = "",
                      @SerializedName("id") val id: String = "",
                      @SerializedName("institution") val institution: String = "",
                      @SerializedName("name") val name: String = "",
                      @SerializedName("number") val number: String = "") {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourceCardDTO = other as ResourceCardDTO
        return links == resourceCardDTO.links && client == resourceCardDTO.client && id == resourceCardDTO.id && institution == resourceCardDTO.institution && name == resourceCardDTO.name && number == resourceCardDTO.number
    }

    override fun hashCode(): Int {
        return Objects.hash(links, client, id, institution, name, number)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourceCardDTO {\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
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