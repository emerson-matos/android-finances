package com.github.emerson.financas.di

import com.github.emerson.financas.business.AuthBusiness
import com.github.emerson.financas.business.ExpenseBusiness
import com.github.emerson.financas.business.UserBusiness
import com.github.emerson.financas.data.repository.expense.API
import com.github.emerson.financas.data.repository.expense.ExpenseRepository
import com.github.emerson.financas.data.repository.expense.ExpenseRepositoryImpl
import com.github.emerson.financas.infrastructure.FinancasDatabase
import com.github.emerson.financas.infrastructure.RetrofitConfiguration
import com.github.emerson.financas.main.expense.list.ExpenseListViewModel
import com.github.emerson.financas.main.home.HomeViewModel
import com.github.emerson.financas.main.login.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModule = module {
    single {
        FirebaseAuth.getInstance()
    }
    single {
        FirebaseAuth.getInstance().currentUser
    }
    factory { SupervisorJob() }
    factory { CoroutineScope(Dispatchers.IO + get<CompletableJob>()) }
}

val repositoryModule = module {
    single<ExpenseRepository> {
        ExpenseRepositoryImpl(get(), get())
    }
}

val businessModule = module {
    single {
        AuthBusiness(get())
    }
    single {
        ExpenseBusiness(get())
    }
    single {
        UserBusiness(get())
    }
}

val apiModule = module {
    single {
        RetrofitConfiguration.getRetrofitInstance().create(API::class.java)
    }
}

val roomModule = module {
    single {
        FinancasDatabase.getDatabase(get()).expenseDao()
    }
}

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
    viewModel {
        ExpenseListViewModel(get())
    }
    viewModel {
        LoginViewModel(get(), get())
    }
}