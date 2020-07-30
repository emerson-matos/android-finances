package br.com.controle.financas.infrastructure

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfiguration {


    companion object {

        private val PATH = "https://www.memerson.tk/api/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(): Retrofit {
            return retrofit
        }
    }
}