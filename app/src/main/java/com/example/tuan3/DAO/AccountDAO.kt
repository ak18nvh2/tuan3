package com.example.tuan3.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tuan3.model.Account

@Dao
interface AccountDAO {
    @Insert
    suspend fun addAccount(account: Account)

    @Query("select * from Account where email = :email")
    fun getAccByEmail(email : String) : Account

}