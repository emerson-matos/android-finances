package com.github.emerson.financas.business

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.IllegalStateException

class AuthBusiness(private val user: FirebaseUser) {
    suspend fun getUserIdToken() = coroutineScope {
        val job = async {
            val res = user.getIdToken(false)
            when {
                res.isSuccessful -> res.result.token
                !res.isSuccessful -> throw IllegalStateException()
                else -> ""
            }
        }
        job.await()
    }
}