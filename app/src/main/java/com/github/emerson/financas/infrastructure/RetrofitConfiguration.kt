package com.github.emerson.financas.infrastructure

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration {


    companion object {

        private val PATH = "http://192.168.0.109:8080/api/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(PATH)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .build()

        /**
         * Retorna uma Instância do Client Retrofit para Requisições
         */
        fun getRetrofitInstance(): Retrofit {
            return retrofit
        }
    }
}