package br.com.controle.financas.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.controle.financas.business.ExpenseBusiness
import br.com.controle.financas.data.model.ExpenseData
import br.com.controle.financas.data.repository.expense.ExpenseRepositoryImpl
import kotlinx.coroutines.launch

class ExpenseViewModel : ViewModel() {
    private val _states = MutableLiveData<List<ExpenseData>>()
    val states: LiveData<List<ExpenseData>>
        get() = _states

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun fetchData() {

        _loading.postValue(true)

        viewModelScope.launch {
            try {
                _states.postValue(ExpenseBusiness(ExpenseRepositoryImpl()).fetchExpenseList())
            } catch (e: Exception) {
                println(e.message)
            } finally {
                _loading.postValue(false)
            }
        }
    }
}
