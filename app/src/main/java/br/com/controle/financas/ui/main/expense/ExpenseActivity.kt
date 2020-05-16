package br.com.controle.financas.ui.main.expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.controle.financas.R
import br.com.controle.financas.ui.main.expense.list.ExpenseListFragment

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
