package com.github.emerson.financas.main.expense.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.emerson.financas.business.ExpenseBusiness
import com.github.emerson.financas.data.model.TransactionDTO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ExpenseViewModel : ViewModel() {
    private val _states = MutableLiveData<List<TransactionDTO>>()
    val states: LiveData<List<TransactionDTO>>
        get() = _states

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    init {
        viewModelScope.launch {
            _loading.postValue(true)
            try {
                print("INIT ")
                delay(1000)
                print("REAL INIT ")
                _states.postValue(expenseBusiness.fetchExpenseList())
            } catch (e: Exception) {
                println(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    private val expenseBusiness = ExpenseBusiness()

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
                val newValue: MutableList<TransactionDTO> =
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
}
