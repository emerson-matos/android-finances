package com.github.emerson.financas.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    private val _token = MutableLiveData<String>()
    val token: LiveData<String>
        get() = _token

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

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