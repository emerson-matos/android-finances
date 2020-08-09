package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import java.util.*

class ResourcesResourceClientDTO(
        @SerializedName("_links") val links: MutableList<Link> = ArrayList(),
        @SerializedName("_embedded") val embedded: MutableList<ResourceClientDTO> = ArrayList()) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourcesResourceClientDTO = other as ResourcesResourceClientDTO
        return embedded == resourcesResourceClientDTO.embedded && links == resourcesResourceClientDTO.links
    }

    override fun hashCode(): Int {
        return Objects.hash(embedded, links)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourcesResourceClientDTO {\n")
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