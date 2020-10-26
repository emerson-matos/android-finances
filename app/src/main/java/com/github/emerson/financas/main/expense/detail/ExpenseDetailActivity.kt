package com.github.emerson.financas.main.expense.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.emerson.financas.R

class ExpenseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.expenseContainer, ExpenseDetailFragment.newInstance())
                .commitNow()
        }
    }
}
