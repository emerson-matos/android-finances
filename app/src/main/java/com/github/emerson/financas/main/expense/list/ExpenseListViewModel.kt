package com.github.emerson.financas.main.expense.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.emerson.financas.business.AuthBusiness
import com.github.emerson.financas.business.ExpenseBusiness
import com.github.emerson.financas.data.model.ExpenseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class ExpenseListViewModel(
    private val expenseBusiness: ExpenseBusiness
) : ViewModel() {

    private val _states = MutableLiveData<List<ExpenseData>>()
    val states: LiveData<List<ExpenseData>>
        get() = _states

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _snackBar = MutableLiveData<Boolean>()
    val snackbar: LiveData<Boolean>
        get() = _snackBar

    init {
        launchDataLoad(Dispatchers.IO) {
            print("INIT")
            delay(1000)
            print("REAL INIT")
            val fetchExpenseList = expenseBusiness.fetchExpenseList()
            _states.postValue(fetchExpenseList)
        }
    }

    fun fetchData() {
        launchDataLoad(Dispatchers.IO) {
            print("REAL fetchData")
            delay(5000)
            print("REAL fetchData")
            _states.postValue(expenseBusiness.fetchExpenseList())
        }
    }

    fun fetchMoreData() {
        launchDataLoad {
            val initialTime = System.currentTimeMillis()
            println("REAL fetchMoreData beginning $initialTime")
            delay(5000)
            println("REAL fetchMoreData ending ${System.currentTimeMillis()} after ${System.currentTimeMillis() - initialTime}")
            val newValue: MutableList<ExpenseData> = mutableListOf(expenseBusiness.fetchExpense())
            _states.value?.let { newValue.addAll(it) }
            _states.postValue(newValue.toList())
        }
    }

    private fun launchDataLoad(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend () -> Unit
    ): Job {
        return viewModelScope.launch(context) {
            try {
                _loading.postValue(true)
                block()
            } catch (error: Throwable) {
                _snackBar.postValue(true)
            } finally {
                _loading.postValue(false)
            }
        }
    }

    fun save() {
        launchDataLoad(Dispatchers.IO) {
            _states.value?.map {
                expenseBusiness.save(it)
            }
        }
    }

    fun showSnackbar() {
        _snackBar.postValue(false)
    }
}
