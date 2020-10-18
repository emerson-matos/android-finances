package com.github.emerson.financas.main.expense.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.emerson.financas.R
import com.github.emerson.financas.data.model.ExpenseData
import kotlinx.android.synthetic.main.expense_detail_fragment.*

class ExpenseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expense_activity)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setDisplayShowHomeEnabled(true)
        val item: ExpenseData? = (intent?.extras?.get("item") as Bundle).get("item") as ExpenseData?
//        supportActionBar?.title = item?.name ?: "123123"
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.expenseContainer, ExpenseDetailFragment.newInstance())
                .commitNow()
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
}
