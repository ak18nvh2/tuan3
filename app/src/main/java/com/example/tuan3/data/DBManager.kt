package com.example.tuan3.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.tuan3.model.TaiKhoan
import java.lang.Exception
import java.sql.SQLException

class DBManager(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DB_Version) {
    companion object {
         val DB_Version = 1
         val ID : String = "id"
         val FULLNAME : String = "fullname"
         val EMAIL : String = "email"
         val PASSWORD : String = "password"
         val DATABASE_NAME : String = "QuanLy"
         val TABLE_NAME : String = "taikhoan"
    }
    var  sql_create =  "CREATE TABLE if not exists " + TABLE_NAME + " (" +
            "${FULLNAME} text, " +
            "${EMAIL} text PRIMARY KEY, "+
            "${PASSWORD} text" +
            ")"
    var context : Context? = null
    init {
        this.context = context
    }
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(sql_create)
            println("create")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun themTaiKhoan (taiKhoan: TaiKhoan) : Int{

        val values = ContentValues()
        values.put(FULLNAME, taiKhoan.getmFullName())
        values.put(EMAIL, taiKhoan.getmEmail())
        values.put(PASSWORD, taiKhoan.getmPassword())
        var sql = "SELECT * FROM "+ TABLE_NAME+" WHERE email='"+taiKhoan.getmEmail()+"'";
        var cursor = readableDatabase.rawQuery(sql, null)
        if(cursor.moveToFirst()){
            Toast.makeText(context, "Đã tồn tại email này!", Toast.LENGTH_LONG).show()
            return  0
        }
        else{
            getWritableDatabase().insert(TABLE_NAME, null, values)
            Toast.makeText(context, "Đăng ký thành công!", Toast.LENGTH_LONG).show()
            return  1
        }
    }

    fun LayTaiKhoanTheoEmail(email : String, pass : String) : Int{
        var sql : String = "Select * from " + TABLE_NAME + " where email='"+email+"'";
        var cr : Cursor = readableDatabase.rawQuery(sql,null)
        if(cr.moveToFirst()){
            if(cr.getString(2) == pass){
                Toast.makeText(context, "Đăng nhập thành công!", Toast.LENGTH_LONG).show()
                return  1
            } else {
                Toast.makeText(context, "Sai mật khẩu!", Toast.LENGTH_LONG).show()
                return 0
            }

        }
        else{
            Toast.makeText(context, "Không tồn tại tài khoản này!", Toast.LENGTH_LONG).show()
            return  0
        }
}
}