package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import java.util.*

class ResourcesResourceInstitutionDTO {
    @SerializedName("_embedded")
    private var embedded: MutableList<ResourceInstitutionDTO> =
        ArrayList<ResourceInstitutionDTO>()

    @SerializedName("_links")
    private var links: MutableList<Link> =
        ArrayList()

    fun embedded(embedded: MutableList<ResourceInstitutionDTO>): ResourcesResourceInstitutionDTO {
        this.embedded = embedded
        return this
    }

    fun addEmbeddedItem(embeddedItem: ResourceInstitutionDTO): ResourcesResourceInstitutionDTO {
        embedded.add(embeddedItem)
        return this
    }

    /**
     * Get embedded
     * @return embedded
     */
    @ApiModelProperty(example = "null", value = "")
    fun getEmbedded(): List<ResourceInstitutionDTO> {
        return embedded
    }

    fun setEmbedded(embedded: MutableList<ResourceInstitutionDTO>) {
        this.embedded = embedded
    }

    fun links(links: MutableList<Link>): ResourcesResourceInstitutionDTO {
        this.links = links
        return this
    }

    fun addLinksItem(linksItem: Link): ResourcesResourceInstitutionDTO {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourcesResourceInstitutionDTO =
            other as ResourcesResourceInstitutionDTO
        return embedded == resourcesResourceInstitutionDTO.embedded &&
                links == resourcesResourceInstitutionDTO.links
    }

    override fun hashCode(): Int {
        return Objects.hash(embedded, links)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourcesResourceInstitutionDTO {\n")
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