package com.github.emerson.financas.main.expense

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.emerson.financas.R
import com.github.emerson.financas.main.expense.list.ExpenseListFragment

class ExpenseActivity : AppCompatActivity() {

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
