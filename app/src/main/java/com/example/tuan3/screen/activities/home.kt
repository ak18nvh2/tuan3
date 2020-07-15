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
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.screen.fragments.HomeFragment
import com.example.tuan3.screen.fragments.MessFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class home : AppCompatActivity(), View.OnClickListener, FeedContentAdapter.AdapterEvent {
    private val SHARE_PREFERENCES_NAME: String = "account"
    private val TAI_KHOAN: String = "tai_khoan"
    private val MAT_KHAU: String = "mat_khau"
    private var arrayList: ArrayList<FeedContent> = ArrayList()
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


        arrayList.add( FeedContent("Martin Palmer",R.drawable.profile,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0,R.drawable.heart, R.drawable.comment_1,"$340.00",1))
        arrayList.add( FeedContent("Pearl Myers",R.drawable.rectangle_copy,"Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$240.00",2))
        arrayList.add( FeedContent("Gary Rose",R.drawable.robin,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                R.drawable.rectangle_copy,R.drawable.heart, R.drawable.comment_1,"$1940.00",3))
        arrayList.add( FeedContent("Adelaide Palmer",R.drawable.luffy,"Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$3420.00",4))
        arrayList.add( FeedContent("Martin Adele",R.drawable.zoro,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0,R.drawable.heart_pink, R.drawable.comment_1,"$3140.00",5))
        arrayList.add( FeedContent("Beatrix Palmer",R.drawable.chopper,"Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$3640.00",6))
        arrayList.add( FeedContent("Martin Belinda",R.drawable.sanji,"Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy,R.drawable.heart, R.drawable.comment_1,"$3540.00",7))


        var adapterHome: FeedContentAdapter = FeedContentAdapter(this,this,arrayList)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = HomeFragment(adapterHome)
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
    fun ImgMessClick(feedContent: FeedContent?){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = MessFragment(feedContent)
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
            imgMess -> ImgMessClick(null)
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

    override fun onClickItem(pos: Int) {
        ImgMessClick(arrayList[pos])
    }


}