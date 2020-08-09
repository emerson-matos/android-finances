package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

class ResourceTransactionDTO {
    @SerializedName("_links")
    private var links: MutableList<Link> =
        ArrayList()

    /**
     * Get account
     * @return account
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("account")
    var account: String? = null

    /**
     * Get card
     * @return card
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("card")
    var card: String? = null

    /**
     * Get client
     * @return client
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("client")
    var client: String? = null

    /**
     * Get currency
     * @return currency
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("currency")
    var currency: String? = null

    /**
     * Get id
     * @return id
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("id")
    var id: String? = null

    /**
     * Get name
     * @return name
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("name")
    var name: String? = null

    /**
     * Get transactionDate
     * @return transactionDate
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("transactionDate")
    var transactionDate: LocalDateTime? = null

    /**
     * Get value
     * @return value
     */
    @get:ApiModelProperty(example = "null", value = "")
    @SerializedName("value")
    var value: BigDecimal? = null
    fun links(links: MutableList<Link>): ResourceTransactionDTO {
        this.links = links
        return this
    }

    fun addLinksItem(linksItem: Link): ResourceTransactionDTO {
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

    fun account(account: String?): ResourceTransactionDTO {
        this.account = account
        return this
    }

    fun card(card: String?): ResourceTransactionDTO {
        this.card = card
        return this
    }

    fun client(client: String?): ResourceTransactionDTO {
        this.client = client
        return this
    }

    fun currency(currency: String?): ResourceTransactionDTO {
        this.currency = currency
        return this
    }

    fun id(id: String?): ResourceTransactionDTO {
        this.id = id
        return this
    }

    fun name(name: String?): ResourceTransactionDTO {
        this.name = name
        return this
    }

    fun transactionDate(transactionDate: LocalDateTime?): ResourceTransactionDTO {
        this.transactionDate = transactionDate
        return this
    }

    fun value(value: BigDecimal?): ResourceTransactionDTO {
        this.value = value
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val resourceTransactionDTO =
            other as ResourceTransactionDTO
        return links == resourceTransactionDTO.links &&
                account == resourceTransactionDTO.account &&
                card == resourceTransactionDTO.card &&
                client == resourceTransactionDTO.client &&
                currency == resourceTransactionDTO.currency &&
                id == resourceTransactionDTO.id &&
                name == resourceTransactionDTO.name &&
                transactionDate == resourceTransactionDTO.transactionDate &&
                value == resourceTransactionDTO.value
    }

    override fun hashCode(): Int {
        return Objects.hash(
            links,
            account,
            card,
            client,
            currency,
            id,
            name,
            transactionDate,
            value
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class ResourceTransactionDTO {\n")
        sb.append("    links: ").append(toIndentedString(links)).append("\n")
        sb.append("    account: ").append(toIndentedString(account)).append("\n")
        sb.append("    card: ").append(toIndentedString(card)).append("\n")
        sb.append("    client: ").append(toIndentedString(client)).append("\n")
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n")
        sb.append("    id: ").append(toIndentedString(id)).append("\n")
        sb.append("    name: ").append(toIndentedString(name)).append("\n")
        sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n")
        sb.append("    value: ").append(toIndentedString(value)).append("\n")
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