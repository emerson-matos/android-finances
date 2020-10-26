package com.github.emerson.financas.main.expense.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.emerson.financas.R

class ExpenseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.expenseContainer, ExpenseListFragment.newInstance())
                .commitNow()
        }
    }
}
