package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import java.util.*

class ResourceBankAccountDTO {
    @SerializedName("_links")
    private var links: MutableList<Link> =
        ArrayList()

    /**
     * Get agency
     * @return agency
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("agency")
    var agency: String? = null

    /**
     * Get dac
     * @return dac
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("dac")
    var dac: String? = null

    /**
     * Get id
     * @return id
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("id")
    var id: String? = null

    /**
     * Get institution
     * @return institution
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("institution")
    var institution: String? = null

    /**
     * Get number
     * @return number
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("number")
    var number: String? = null

    /**
     * Get responsible
     * @return responsible
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("responsible")
    var responsible: String? = null
    fun links(links: MutableList<Link>): ResourceBankAccountDTO {
        this.links = links
        return this
    }

    fun addLinksItem(linksItem: Link): ResourceBankAccountDTO {
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

    fun agency(agency: String?): ResourceBankAccountDTO {
        this.agency = agency
        return this
    }

    fun dac(dac: String?): ResourceBankAccountDTO {
        this.dac = dac
        return this
    }

    fun id(id: String?): ResourceBankAccountDTO {
        this.id = id
        return this
    }

    fun institution(institution: String?): ResourceBankAccountDTO {
        this.institution = institution
        return this
    }

    fun number(number: String?): ResourceBankAccountDTO {
        this.number = number
        return this
    }

    fun responsible(responsible: String?): ResourceBankAccountDTO {
        this.responsible = responsible
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourceBankAccountDTO =
            other as ResourceBankAccountDTO
        return links == resourceBankAccountDTO.links &&
                agency == resourceBankAccountDTO.agency &&
                dac == resourceBankAccountDTO.dac &&
                id == resourceBankAccountDTO.id &&
                institution == resourceBankAccountDTO.institution &&
                number == resourceBankAccountDTO.number &&
                responsible == resourceBankAccountDTO.responsible
    }

    override fun hashCode(): Int {
        return Objects.hash(links, agency, dac, id, institution, number, responsible)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourceBankAccountDTO {\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
        sb.append("    agency: ").append(toIndentedString(agency)).append("\n")
        sb.append("    dac: ").append(toIndentedString(dac)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    institution: ").append(toIndentedString(institution)).append("\n")
        sb.append("    number: ").append(toIndentedString(number)).append("\n")
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