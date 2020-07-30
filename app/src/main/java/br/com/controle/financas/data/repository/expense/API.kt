package br.com.controle.financas.data.repository.expense

import br.com.controle.financas.data.model.LoggedUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface API {
    @GET("client")
    fun getClients(@Header("X-Authorization-Firebase") auth: String) : Call<List<LoggedUser>>
}
