package com.example.tuan3.screen.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.fragments.HomeFragment
import com.example.tuan3.screen.fragments.MessFragment
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity(), View.OnClickListener, ICommunicateFragment {
    private val SHARE_PREFERENCES_NAME: String = "account"
    private val TAI_KHOAN: String = "tai_khoan"
    private val MAT_KHAU: String = "mat_khau"
    lateinit var adapterHome: FeedContentAdapter
    lateinit var feedContent: FeedContent
    private val listFragment = arrayListOf(HomeFragment(), MessFragment())
    private var arrayList: ArrayList<FeedContent> = ArrayList()
    var tk: String? = null
    var mk: String? = null
    var checkLogOut: Int = 1
    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val intent = intent
        tk = intent.getStringExtra("email")
        mk = intent.getStringExtra("pass")
        imgHome.setOnClickListener(this)
        imgMess.setOnClickListener(this)
        imgPro.setOnClickListener(this)
        showFragment(listFragment[0])


    }


    override fun onClick(v: View) {

        when (v) {
            imgHome -> showFragment(listFragment[0])
            imgMess -> showFragment(listFragment[1])
            imgPro -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
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

    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
            listFragment.forEach {
                if (it != fragment) fragmentTransaction.hide(it)
            }
        } else {
            fragmentTransaction.add(R.id.frameHome, fragment)
        }
        fragmentTransaction.commit()
        val i= listFragment.indexOf(fragment)
        if(i == 0){
            tvHome.setBackgroundColor(resources.getColor(R.color.red))
            tvPlus.setBackgroundColor(resources.getColor(R.color.white))
            tvPro.setBackgroundColor(resources.getColor(R.color.white))
            tvNoti.setBackgroundColor(resources.getColor(R.color.white))
            tvMess.setBackgroundColor(resources.getColor(R.color.white))
            imgMess.setImageResource(R.drawable.group_8_white)
            imgHome.setImageResource(R.drawable.group_7)
        } else if(i == 1){
            tvMess.setBackgroundColor(resources.getColor(R.color.red))
            tvHome.setBackgroundColor(resources.getColor(R.color.white))
            tvPlus.setBackgroundColor(resources.getColor(R.color.white))
            tvPro.setBackgroundColor(resources.getColor(R.color.white))
            tvNoti.setBackgroundColor(resources.getColor(R.color.white))
            imgMess.setImageResource(R.drawable.group_8)
            imgHome.setImageResource(R.drawable.group_7_white)
        }
    }


    override fun doSomeThing(string: MessContent) {
        var i = 0
        when {
            listFragment[0].isVisible -> {
                showFragment(listFragment[1])
                (listFragment[1] as? MessFragment)?.let {

                    it.list.forEachIndexed { index, messContent ->
                        if (it.list[index].mID == string.mID)
                            i = index
                    }
                    it.list.removeAt(i)
                    it.list.add(0, string)
                    it.mAdapter?.setList(it.list)
                }
            }
        }
    }


}


interface ICommunicateFragment {
    fun doSomeThing(string: MessContent)
}