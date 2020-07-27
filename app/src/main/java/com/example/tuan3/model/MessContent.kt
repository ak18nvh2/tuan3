package com.example.tuan3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MessContent")
data class MessContent(
                       @ColumnInfo(name = "name")
                       var name: String,
                       @ColumnInfo(name = "avatar")
                       var avt: Int,
                       @ColumnInfo(name = "time")
                       var time: String,
                       @ColumnInfo(name = "content")
                       var content: String,
                       @ColumnInfo(name = "noti")
                       var noti: String,
                       @ColumnInfo(name = "id")
                       var mID: Int){
    @PrimaryKey(autoGenerate = true)
    var numberOrder: Int = 0

}
