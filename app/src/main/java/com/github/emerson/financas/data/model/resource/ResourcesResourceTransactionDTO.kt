package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import java.util.*

class ResourcesResourceTransactionDTO {
    @SerializedName("_embedded")
    private var embedded: MutableList<ResourceTransactionDTO> =
        ArrayList<ResourceTransactionDTO>()

    @SerializedName("_links")
    private var links: MutableList<Link> =
        ArrayList()

    fun embedded(embedded: MutableList<ResourceTransactionDTO>): ResourcesResourceTransactionDTO {
        this.embedded = embedded
        return this
    }

    fun addEmbeddedItem(embeddedItem: ResourceTransactionDTO): ResourcesResourceTransactionDTO {
        embedded.add(embeddedItem)
        return this
    }

    /**
     * Get embedded
     * @return embedded
     */
    @ApiModelProperty(example = "null", value = "")
    fun getEmbedded(): List<ResourceTransactionDTO> {
        return embedded
    }

    fun setEmbedded(embedded: MutableList<ResourceTransactionDTO>) {
        this.embedded = embedded
    }

    fun links(links: MutableList<Link>): ResourcesResourceTransactionDTO {
        this.links = links
        return this
    }

    fun addLinksItem(linksItem: Link): ResourcesResourceTransactionDTO {
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
        val resourcesResourceTransactionDTO =
            other as ResourcesResourceTransactionDTO
        return embedded == resourcesResourceTransactionDTO.embedded &&
                links == resourcesResourceTransactionDTO.links
    }

    override fun hashCode(): Int {
        return Objects.hash(embedded, links)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourcesResourceTransactionDTO {\n")
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