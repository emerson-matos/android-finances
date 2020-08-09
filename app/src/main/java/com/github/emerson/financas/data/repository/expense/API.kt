package com.github.emerson.financas.data.repository.expense

import com.github.emerson.financas.data.model.resource.ResourcesResourceClientDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface API {
    @GET("client")
    fun getClients(@Header("X-Authorization-Firebase") auth: String): Call<ResourcesResourceClientDTO>

    @POST("open/signup")
    fun signUpUsingPOST(@Header("X-Firebase-User") xFirebaseUser: String): Call<Void?>?
}
