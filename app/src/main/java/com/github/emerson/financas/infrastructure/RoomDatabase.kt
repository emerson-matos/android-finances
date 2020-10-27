package com.github.emerson.financas.infrastructure

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.emerson.financas.data.entity.ExpenseDataEntity
import com.github.emerson.financas.data.repository.expense.ExpenseDAO
import kotlinx.coroutines.CoroutineScope

@Database(entities = [ExpenseDataEntity::class], version = 1, exportSchema = false)
abstract class FinancasDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FinancasDatabase? = null

        fun getDatabase(context: Context): FinancasDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FinancasDatabase::class.java,
                    "financas_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}