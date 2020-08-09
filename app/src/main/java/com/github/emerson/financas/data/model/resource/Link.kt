package com.github.emerson.financas.data.model.resource

import com.google.gson.annotations.SerializedName
import java.util.*

class Link(
    @SerializedName("deprecation") val deprecation: String = "",
    @SerializedName("href") val href: String = "",
    @SerializedName("hreflang") val hreflang: String = "",
    @SerializedName("media") val media: String = "",
    @SerializedName("rel") val rel: String = "",
    @SerializedName("templated") val templated: Boolean = false,
    @SerializedName("title") val title: String = "",
    @SerializedName("type") val type: String = ""
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val link =
            other as Link
        return deprecation == link.deprecation &&
                href == link.href &&
                hreflang == link.hreflang &&
                media == link.media &&
                rel == link.rel &&
                templated == link.templated &&
                title == link.title &&
                type == link.type
    }

    override fun hashCode(): Int {
        return Objects.hash(
            deprecation,
            href,
            hreflang,
            media,
            rel,
            templated,
            title,
            type
        )
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Link {\n")
        sb.append("    deprecation: ").append(toIndentedString(deprecation)).append("\n")
        sb.append("    href: ").append(toIndentedString(href)).append("\n")
        sb.append("    hreflang: ").append(toIndentedString(hreflang)).append("\n")
        sb.append("    media: ").append(toIndentedString(media)).append("\n")
        sb.append("    rel: ").append(toIndentedString(rel)).append("\n")
        sb.append("    templated: ").append(toIndentedString(templated)).append("\n")
        sb.append("    title: ").append(toIndentedString(title)).append("\n")
        sb.append("    type: ").append(toIndentedString(type)).append("\n")
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