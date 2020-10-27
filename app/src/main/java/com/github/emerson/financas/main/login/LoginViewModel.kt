package com.github.emerson.financas.main.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.emerson.financas.business.AuthBusiness
import com.github.emerson.financas.business.UserBusiness
import kotlinx.coroutines.launch

class LoginViewModel(private val auth: AuthBusiness, private val userBusiness: UserBusiness) :
    ViewModel() {

    fun registerUser() {
        viewModelScope.launch {
            auth.getUserIdToken()?.let {
                userBusiness.createUser(it)
            }
        }
    }

}
