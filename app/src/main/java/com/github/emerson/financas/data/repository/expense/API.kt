package com.github.emerson.financas.data.repository.expense

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface API {
    @GET("client")
    suspend fun getClients(@Header("X-Authorization-Firebase") auth: String) : Map<String, Map<String, Any>>

    @POST("open/signup")
    suspend fun createUser(@Header("X-Firebase-User") auth: String) : Any
}
