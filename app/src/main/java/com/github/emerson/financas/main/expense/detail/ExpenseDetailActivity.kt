package com.github.emerson.financas.main.expense.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.emerson.financas.R
import com.github.emerson.financas.data.model.ExpenseData

class ExpenseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_activity)
        val item: ExpenseData? = (intent?.extras?.get("item") as Bundle).get("item") as ExpenseData?

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.expenseContainer, ExpenseDetailFragment.newInstance())
                .commitNow()
        }
    }
}
