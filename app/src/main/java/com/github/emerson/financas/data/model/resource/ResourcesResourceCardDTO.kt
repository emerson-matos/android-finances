package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import java.util.*

class ResourcesResourceCardDTO(@SerializedName("_links") val links: MutableList<Link>,
                               @SerializedName("_embedded")
                               val embedded: MutableList<ResourceCardDTO>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourcesResourceCardDTO = other as ResourcesResourceCardDTO
        return embedded == resourcesResourceCardDTO.embedded && links == resourcesResourceCardDTO.links
    }

    override fun hashCode(): Int {
        return Objects.hash(embedded, links)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourcesResourceCardDTO {\n")
        sb.append("    embedded: ").append(toIndentedString(embedded)).append("\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
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