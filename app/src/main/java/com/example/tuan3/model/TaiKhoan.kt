package com.example.tuan3.model

class TaiKhoan {
    private var mId : Int = 0
    private lateinit var mFullName : String
    private lateinit var mEmail : String
    private  lateinit var mPassword : String
    fun getmID (): Int {
        return this.mId
    }
    fun getmFullName() : String{
        return  this.mFullName
    }
    fun  getmEmail() : String{
        return  this.mEmail
    }
    fun getmPassword() : String{
        return  this.mPassword
    }
    fun  setmFullName(mFullName: String){
        this.mFullName= mFullName
    }
    fun setmEmail(mEmail: String){
        this.mEmail = mEmail
    }
    fun setmPassword(mPassword: String){
        this.mPassword = mPassword
    }

    constructor(mFullName: String, mEmail: String, mPassword: String) {
        this.mFullName = mFullName
        this.mEmail = mEmail
        this.mPassword = mPassword
    }

    constructor(mId: Int, mFullName: String, mEmail: String, mPassword: String) {
        this.mId = mId
        this.mFullName = mFullName
        this.mEmail = mEmail
        this.mPassword = mPassword
    }


}