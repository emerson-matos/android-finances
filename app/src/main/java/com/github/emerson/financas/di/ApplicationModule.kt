package com.github.emerson.financas.di

import com.github.emerson.financas.business.ExpenseBusiness
import com.github.emerson.financas.data.repository.expense.ExpenseRepository
import com.github.emerson.financas.data.repository.expense.ExpenseRepositoryImpl
import com.github.emerson.financas.main.expense.list.ExpenseListViewModel
import com.github.emerson.financas.main.home.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single {
        FirebaseAuth.getInstance()
    }
    single {
        ExpenseBusiness(get())
    }
}

val repositoryModule = module {
    single<ExpenseRepository> {
        ExpenseRepositoryImpl()
    }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        ExpenseListViewModel(get())
    }
}