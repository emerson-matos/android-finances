package com.github.emerson.financas.infrastructure

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration {


    companion object {

        private val PATH = "https://memerson.tk/api/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(PATH)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .build()

        /** Retorna uma Instância do Client Retrofit para Requisições
         */
        fun getRetrofitInstance(): Retrofit {
            return retrofit
        }
    }
}