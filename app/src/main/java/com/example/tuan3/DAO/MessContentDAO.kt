package com.example.tuan3.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tuan3.model.Account
import com.example.tuan3.model.MessContent

@Dao
interface MessContentDAO {
    @Insert
    suspend fun addMessContent(messContent: MessContent)

    @Query("select * from MessContent order by numberOrder desc")
    fun getAllMessContent() : List<MessContent>

    @Query("delete from MessContent where id = :id")
    fun deleteByID(id : Int)

}