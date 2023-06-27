package com.sheikh.crytoworld.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sheikh.crytoworld.data.database.db_model.coin_full_info.CoinPriceInfo

@Database(entities = [CoinPriceInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var database: AppDatabase? = null
        private const val databaseName = "main.db"

        fun getInstance(context: Context): AppDatabase {
            database?.let { return it }
            val instance =
                Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
            database = instance
            return instance
        }
    }

    abstract fun getDao(): CoinDao
}