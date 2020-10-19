package com.github.emerson.financas.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val endpoint = RetrofitConfiguration.getRetrofitInstance().create(API::class.java)
    private val _token = MutableLiveData<String>()
    val token: LiveData<String>
        get() = _token

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    fun loadData() {
        _token.value?.let {
            val callback = endpoint.getClients(it)
            callback.enqueue(object :
                Callback<Map<String, Map<String, Any>>> {
                override fun onFailure(
                    call: Call<Map<String, Map<String, Any>>>,
                    t: Throwable
                ) {
                    println("errorrrrrrrrrrrrr")
                    _error.value = true
                }

                override fun onResponse(
                    call: Call<Map<String, Map<String, Any>>>,
                    response: Response<Map<String, Map<String, Any>>>
                ) {
                    _error.value = false
                    println(response.body()?.get("_embedded")?.get("clientDTOList"))
                }
            })
        }
    }

    fun loadToken() {
        FirebaseAuth.getInstance()//
            .currentUser?.getIdToken(true)//
            ?.addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    _error.value = true
                } else {
                    val idToken = task.result?.token
                    _token.value = idToken
                }
            }
    }
}