package com.github.emerson.financas.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoggedUserDTO(
    @Expose
    @SerializedName("name")
    var name: String,
    @Expose
    @SerializedName("id")
    var id: Int
)