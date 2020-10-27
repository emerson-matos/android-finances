package com.github.emerson.financas

import android.app.Application
import com.github.emerson.financas.di.*
import com.github.emerson.financas.di.businessModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FinancasApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@FinancasApp)
            modules(
                listOf(applicationModule, apiModule, roomModule, businessModule, viewModelModule, repositoryModule)
            )
        }
    }
}