package com.example.tuan3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class Account(@PrimaryKey val email: String,
                   @ColumnInfo(name = "FullName") val fullName: String,
                   @ColumnInfo(name = "Password") val passWord: String)