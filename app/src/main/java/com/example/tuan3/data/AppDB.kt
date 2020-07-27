package com.example.tuan3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tuan3.DAO.AccountDAO
import com.example.tuan3.DAO.MessContentDAO
import com.example.tuan3.model.Account
import com.example.tuan3.model.MessContent

@Database(entities = [(Account::class),(MessContent::class)],version = 3)
abstract class AppDB : RoomDatabase(){
    abstract fun accountDAO() : AccountDAO
    abstract fun messContentDAO() : MessContentDAO
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
                ).fallbackToDestructiveMigration().run { allowMainThreadQueries() }.build()
                INSTANCE = instance
                return instance
            }
        }
    }
}