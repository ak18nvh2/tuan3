package com.example.tuan3.screen.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tuan3.R
import com.example.tuan3.screen.fragments.HomeFragment
import com.example.tuan3.screen.fragments.MessFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class home : AppCompatActivity(), View.OnClickListener {
    private val SHARE_PREFERENCES_NAME: String = "account"
    private val TAI_KHOAN: String = "tai_khoan"
    private val MAT_KHAU: String = "mat_khau"
    var tk: String? = null
    var mk: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val intent = intent
        tk = intent.getStringExtra("email")
        mk = intent.getStringExtra("pass")
        ImgHomeClick()
        imgHome.setOnClickListener(this)
        imgMess.setOnClickListener(this)
        imgNoti.setOnClickListener(this)
        imgPlus.setOnClickListener(this)
        imgPro.setOnClickListener(this)

    }
    fun ImgHomeClick (){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = HomeFragment()
        fragmentTransaction.replace(R.id.frameHome, fragment)
        fragmentTransaction.commit()
        tvHome.setBackgroundColor(resources.getColor(R.color.red))
        tvPlus.setBackgroundColor(resources.getColor(R.color.white))
        tvPro.setBackgroundColor(resources.getColor(R.color.white))
        tvNoti.setBackgroundColor(resources.getColor(R.color.white))
        tvMess.setBackgroundColor(resources.getColor(R.color.white))
        imgMess.setImageResource(R.drawable.group_8_white)
        imgHome.setImageResource(R.drawable.group_7)
    }
    fun ImgMessClick(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = MessFragment()
        fragmentTransaction.replace(R.id.frameHome, fragment)
        fragmentTransaction.commit()
        tvMess.setBackgroundColor(resources.getColor(R.color.red))
        tvHome.setBackgroundColor(resources.getColor(R.color.white))
        tvPlus.setBackgroundColor(resources.getColor(R.color.white))
        tvPro.setBackgroundColor(resources.getColor(R.color.white))
        tvNoti.setBackgroundColor(resources.getColor(R.color.white))
        imgMess.setImageResource(R.drawable.group_8)
        imgHome.setImageResource(R.drawable.group_7_white)
    }
    override fun  onClick(v: View){

        when(v){
            imgHome -> ImgHomeClick()
            imgMess -> ImgMessClick()
            imgPlus -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                tvHome.setBackgroundColor(resources.getColor(R.color.white))
                tvPlus.setBackgroundColor(resources.getColor(R.color.red))
                tvPro.setBackgroundColor(resources.getColor(R.color.white))
                tvNoti.setBackgroundColor(resources.getColor(R.color.white))
            }
            imgNoti -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                tvHome.setBackgroundColor(resources.getColor(R.color.white))
                tvPlus.setBackgroundColor(resources.getColor(R.color.white))
                tvPro.setBackgroundColor(resources.getColor(R.color.white))
                tvNoti.setBackgroundColor(resources.getColor(R.color.red))
            }
            imgPro -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                tvHome.setBackgroundColor(resources.getColor(R.color.white))
                tvPlus.setBackgroundColor(resources.getColor(R.color.white))
                tvPro.setBackgroundColor(resources.getColor(R.color.red))
                tvNoti.setBackgroundColor(resources.getColor(R.color.white))
                val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = share.edit()
                val intent : Intent = Intent(this, MainActivity::class.java )
                intent.putExtra("email",share.getString(TAI_KHOAN,""))
                intent.putExtra("pass", share.getString(MAT_KHAU,""))
                editor.remove(MAT_KHAU)
                editor.apply()
                startActivity(intent)
            }

        }
    }
}