package br.com.eduardomaxwell.mycurrencyconverter.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.eduardomaxwell.mycurrencyconverter.data.database.dao.ExchangeDao
import br.com.eduardomaxwell.mycurrencyconverter.data.model.ExchangeResponseValue

@Database(entities = [ExchangeResponseValue::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exchangeDao(): ExchangeDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "exchange_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


}