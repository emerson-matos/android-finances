package com.github.emerson.financas.main.expense.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.emerson.financas.data.model.ExpenseData

class ExpenseDetailViewModel : ViewModel() {

    private val _item = MutableLiveData<ExpenseData>()
    val item: LiveData<ExpenseData>
        get() = _item

    private val _cardVisibility = MutableLiveData(false)
    val cardVisibility: LiveData<Boolean>
        get() = _cardVisibility

    private val _accountVisibility = MutableLiveData(false)
    val accountVisibility: LiveData<Boolean>
        get() = _accountVisibility

    fun getExpense(itemId: Long?) {
        _item.value = ExpenseData(id = itemId ?: -1)
        itemId?.let {
            when {
                it % 3 == 0L -> {
                    _accountVisibility.value = true
                    _cardVisibility.value = true
                }
                it % 2 == 0L -> {
                    _cardVisibility.value = true
                    _accountVisibility.value = false
                }
                else -> {
                    _accountVisibility.value = true
                    _cardVisibility.value = false
                }
            }
        }
    }
}