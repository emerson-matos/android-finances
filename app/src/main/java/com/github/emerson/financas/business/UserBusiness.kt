package com.github.emerson.financas.business

import com.github.emerson.financas.data.repository.expense.API

class UserBusiness(private val api: API) {
    suspend fun createUser(auth: String) {
        api.createUser(auth)
    }
}