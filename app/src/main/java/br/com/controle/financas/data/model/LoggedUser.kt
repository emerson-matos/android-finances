package br.com.controle.financas.data.model

import com.google.gson.annotations.SerializedName

data class LoggedUser(
    @SerializedName("name")
    var name : String,
    @SerializedName("id")
    var id : Int
)