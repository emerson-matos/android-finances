package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import java.util.*

class ResourceInstitutionDTO {
    @SerializedName("_links")
    private var links: MutableList<Link> =
        ArrayList()

    /**
     * Get id
     * @return id
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("id")
    var id: String? = null

    /**
     * Get identifier
     * @return identifier
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("identifier")
    var identifier: String? = null

    /**
     * Get name
     * @return name
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("name")
    var name: String? = null
    fun links(links: MutableList<Link>): ResourceInstitutionDTO {
        this.links = links
        return this
    }

    fun addLinksItem(linksItem: Link): ResourceInstitutionDTO {
        links.add(linksItem)
        return this
    }

    /**
     * Get links
     * @return links
     */
    @ApiModelProperty(example = "null", value = "")
    fun getLinks(): List<Link> {
        return links
    }

    fun setLinks(links: MutableList<Link>) {
        this.links = links
    }

    fun id(id: String?): ResourceInstitutionDTO {
        this.id = id
        return this
    }

    fun identifier(identifier: String?): ResourceInstitutionDTO {
        this.identifier = identifier
        return this
    }

    fun name(name: String?): ResourceInstitutionDTO {
        this.name = name
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourceInstitutionDTO =
            other as ResourceInstitutionDTO
        return links == resourceInstitutionDTO.links &&
                id == resourceInstitutionDTO.id &&
                identifier == resourceInstitutionDTO.identifier &&
                name == resourceInstitutionDTO.name
    }

    override fun hashCode(): Int {
        return Objects.hash(links, id, identifier, name)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourceInstitutionDTO {\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
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