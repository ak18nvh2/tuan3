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
    var checkLogOut: Int = 1
    val fragmentManager = supportFragmentManager
    lateinit var adapterHome: FeedContentAdapter
    lateinit var fragment: HomeFragment
    lateinit var fragmentMess: MessFragment
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        this.init()
        val intent = intent
        tk = intent.getStringExtra("email")
        mk = intent.getStringExtra("pass")

        imgHome.setOnClickListener(this)
        imgMess.setOnClickListener(this)
       
        imgPro.setOnClickListener(this)


    }

    fun ImgHomeClick() {


        fragmentManager.popBackStack("FeedFrag", 0)


        // set navigation bar
        tvHome.setBackgroundColor(resources.getColor(R.color.red))
        tvPlus.setBackgroundColor(resources.getColor(R.color.white))
        tvPro.setBackgroundColor(resources.getColor(R.color.white))
        tvNoti.setBackgroundColor(resources.getColor(R.color.white))
        tvMess.setBackgroundColor(resources.getColor(R.color.white))
        imgMess.setImageResource(R.drawable.group_8_white)
        imgHome.setImageResource(R.drawable.group_7)
    }

    fun ImgMessClick(feedContent: FeedContent?) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        val frag = supportFragmentManager.findFragmentByTag("MessFrag")
        if (frag != null) {
            Toast.makeText(this, "Cos rooif nef", Toast.LENGTH_SHORT).show()
            fragmentManager.popBackStack("MessFrag", 0)
        } else {
            fragmentMess = MessFragment(feedContent)
            fragmentTransaction.replace(R.id.frameHome, fragmentMess, "MessFrag")
            fragmentTransaction.addToBackStack("MessFrag")
            fragmentTransaction.commit()
        }


        tvMess.setBackgroundColor(resources.getColor(R.color.red))
        tvHome.setBackgroundColor(resources.getColor(R.color.white))
        tvPlus.setBackgroundColor(resources.getColor(R.color.white))
        tvPro.setBackgroundColor(resources.getColor(R.color.white))
        tvNoti.setBackgroundColor(resources.getColor(R.color.white))
        imgMess.setImageResource(R.drawable.group_8)
        imgHome.setImageResource(R.drawable.group_7_white)
    }

    override fun onClick(v: View) {

        when (v) {
            imgHome -> ImgHomeClick()
            imgMess -> ImgMessClick(null)

            imgPro -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                tvHome.setBackgroundColor(resources.getColor(R.color.white))
                tvPlus.setBackgroundColor(resources.getColor(R.color.white))
                tvPro.setBackgroundColor(resources.getColor(R.color.red))
                tvNoti.setBackgroundColor(resources.getColor(R.color.white))
                val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = share.edit()
                val intent: Intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", share.getString(TAI_KHOAN, ""))
                intent.putExtra("pass", share.getString(MAT_KHAU, ""))
                editor.remove(MAT_KHAU)
                editor.apply()
                startActivity(intent)
            }

        }
    }

    override fun onClickItem(pos: Int) {
        ImgMessClick(arrayList[pos])
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            checkLogOut = 1
            supportFragmentManager.popBackStack()
            val frag = supportFragmentManager.findFragmentByTag("FeedFrag")
            if (fragment.isVisible) {
                Toast.makeText(this, "dang hien thi home", Toast.LENGTH_LONG).show()
                tvHome.setBackgroundColor(resources.getColor(R.color.red))
                tvPlus.setBackgroundColor(resources.getColor(R.color.white))
                tvPro.setBackgroundColor(resources.getColor(R.color.white))
                tvNoti.setBackgroundColor(resources.getColor(R.color.white))
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                imgMess.setImageResource(R.drawable.group_8_white)
                imgHome.setImageResource(R.drawable.group_7)
            }
        } else if (supportFragmentManager.backStackEntryCount == 1 && checkLogOut == 1) {
            checkLogOut = 0
            Toast.makeText(this, "Lan nua la out day", Toast.LENGTH_LONG).show()
        } else {
            val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = share.edit()
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("email", share.getString(TAI_KHOAN, ""))
            intent.putExtra("pass", share.getString(MAT_KHAU, ""))
            editor.remove(MAT_KHAU)
            editor.apply()
            startActivity(intent)
        }


    }

    fun init() {
        arrayList.add(FeedContent("Martin Palmer", R.drawable.profile, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0, R.drawable.heart, R.drawable.comment_1, "$340.00", 1))
        arrayList.add(FeedContent("Pearl Myers", R.drawable.rectangle_copy, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$240.00", 2))
        arrayList.add(FeedContent("Gary Rose", R.drawable.robin, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$1940.00", 3))
        arrayList.add(FeedContent("Adelaide Palmer", R.drawable.luffy, "Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$3420.00", 4))
        arrayList.add(FeedContent("Martin Adele", R.drawable.zoro, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0, R.drawable.heart_pink, R.drawable.comment_1, "$3140.00", 5))
        arrayList.add(FeedContent("Beatrix Palmer", R.drawable.chopper, "Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$3640.00", 6))
        arrayList.add(FeedContent("Martin Belinda", R.drawable.sanji, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 7))

        this.adapterHome = FeedContentAdapter(this, this, arrayList)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragment = HomeFragment(adapterHome)
        fragmentTransaction.replace(R.id.frameHome, fragment, "FeedFrag")
        fragmentTransaction.addToBackStack("FeedFrag")
        fragmentTransaction.commit()
        tvHome.setBackgroundColor(resources.getColor(R.color.red))
        tvPlus.setBackgroundColor(resources.getColor(R.color.white))
        tvPro.setBackgroundColor(resources.getColor(R.color.white))
        tvNoti.setBackgroundColor(resources.getColor(R.color.white))
        tvMess.setBackgroundColor(resources.getColor(R.color.white))
        imgMess.setImageResource(R.drawable.group_8_white)
        imgHome.setImageResource(R.drawable.group_7)
    }


}