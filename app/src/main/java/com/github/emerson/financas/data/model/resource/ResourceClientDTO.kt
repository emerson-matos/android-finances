package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import java.util.*

class ResourceClientDTO(@SerializedName("_links") val links: MutableList<Link> = ArrayList(),
                        @SerializedName("owner") val owner: String = "",
                        @SerializedName("name") val name: String = "",
                        @SerializedName("id") val id: String = "") {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourceClientDTO = other as ResourceClientDTO
        return links == resourceClientDTO.links && id == resourceClientDTO.id && name == resourceClientDTO.name && owner == resourceClientDTO.owner
    }

    override fun hashCode(): Int {
        return Objects.hash(links, id, name, owner)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourceClientDTO {\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n")
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