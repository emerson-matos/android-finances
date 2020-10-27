package com.github.emerson.financas.main.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val endpoint = RetrofitConfiguration.getRetrofitInstance().create(API::class.java)

    fun registerUser() {
        viewModelScope.launch {
            FirebaseAuth.getInstance()//
                .currentUser?.getIdToken(true)//
                ?.addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        registerUser()
                    } else {
                        task.result?.token?.let {
                            endpoint.createUser(it).enqueue(object :
                                Callback<Any> {
                                override fun onFailure(
                                    call: Call<Any>,
                                    t: Throwable
                                ) {
                                    println("errorrrrrrrrrrrrr")
                                }

                                override fun onResponse(
                                    call: Call<Any>,
                                    response: Response<Any>
                                ) {
                                    println(response.body())
                                }
                            })
                        }
                    }
                }
        }
    }

}
