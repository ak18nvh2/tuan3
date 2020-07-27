package com.example.tuan3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tuan3.DAO.AccountDAO
import com.example.tuan3.model.Account

@Database(entities = [(Account::class)],version = 1)
abstract class AppDB : RoomDatabase(){
    abstract fun accountDAO() : AccountDAO

    companion object {
        private var INSTANCE: AppDB?= null
        private val DB_NAME = "user_database"

        fun getDatabase(context: Context): AppDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDB::class.java,
                        DB_NAME
                ).run { allowMainThreadQueries() }.build()
                INSTANCE = instance
                return instance
            }
        }
    }
}