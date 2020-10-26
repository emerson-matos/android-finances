package com.github.emerson.financas.main.expense.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.emerson.financas.business.ExpenseBusiness
import com.github.emerson.financas.data.model.ExpenseData
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExpenseListViewModel(private val expenseBusiness: ExpenseBusiness) : ViewModel() {

    private val endpoint = RetrofitConfiguration.getRetrofitInstance().create(API::class.java)

    private val _states = MutableLiveData<List<ExpenseData>>()
    val states: LiveData<List<ExpenseData>>
        get() = _states

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    init {
        viewModelScope.launch {
            _loading.postValue(true)
            try {
                print("INIT")
                delay(1000)
                print("REAL INIT")
                _states.postValue(expenseBusiness.fetchExpenseList())
            } catch (e: Exception) {
                println(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun fetchData() {

        _loading.postValue(true)

        viewModelScope.launch {
            try {
                print("REAL fetchData")
                delay(5000)
                print("REAL fetchData")
                _states.postValue(expenseBusiness.fetchExpenseList())
            } catch (e: Exception) {
                println(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun fetchMoreData() {
        _loading.postValue(true)
        viewModelScope.launch {
            try {
                print("REAL fetchMoreData beginning ${System.currentTimeMillis()}")
                delay(5000)
                print("REAL fetchMoreData ending ${System.currentTimeMillis()}")
                val newValue: MutableList<ExpenseData> =
                    mutableListOf(expenseBusiness.fetchExpense())
                _states.value?.let { newValue.addAll(it) }
                _states.postValue(newValue.toList())
            } catch (e: Exception) {
                println(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun loadData() {
        FirebaseAuth.getInstance()//
            .currentUser?.getIdToken(true)?.addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    println("ERROR")
//                    _error.value = true
                } else {
                    val idToken = task.result?.token
//                    _token.value = idToken
                    idToken?.let {
                        val callback = endpoint.getClients(it)
                        callback.enqueue(object :
                            Callback<Map<String, Map<String, Any>>> {
                            override fun onFailure(
                                call: Call<Map<String, Map<String, Any>>>,
                                t: Throwable
                            ) {
                                println("error")
//                            _error.value = true
                            }

                            override fun onResponse(
                                call: Call<Map<String, Map<String, Any>>>,
                                response: Response<Map<String, Map<String, Any>>>
                            ) {
//                            _error.value = false
                                println(response.body()?.get("_embedded")?.get("clientDTOList"))
                            }
                        })
                    }
                }
            }
    }
}
