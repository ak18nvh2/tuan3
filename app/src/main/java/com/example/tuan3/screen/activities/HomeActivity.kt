package com.example.tuan3.screen.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tuan3.R
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.fragments.FeedFragment
import com.example.tuan3.screen.fragments.MessFragment
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity(), View.OnClickListener, ICommunicateFragment {

    private val listFragment = arrayListOf(FeedFragment(), MessFragment())

    private val fragmentManager : FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        img_Home.setOnClickListener(this)
        img_Mess.setOnClickListener(this)
        img_Pro.setOnClickListener(this)

        val fragmentTransaction = fragmentManager.beginTransaction()
        listFragment.forEachIndexed { index, fragment ->
            fragmentTransaction.add(R.id.frameHome, fragment)
            fragmentTransaction.hide(fragment)
        }
        fragmentTransaction.show(listFragment[0])
        fragmentTransaction.commit()



    }


    override fun onClick(v: View) {

        when (v) {
            img_Home -> showFragment(listFragment[0])
            img_Mess -> showFragment(listFragment[1])
            img_Pro -> {
                tvMess.setBackgroundColor(resources.getColor(R.color.white))
                val share: SharedPreferences = getSharedPreferences(SignInActivity.SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = share.edit()
                val intent: Intent = Intent(this, SignInActivity::class.java)
                editor.remove(SignInActivity.PASSWORD)
                editor.apply()
                startActivity(intent)
                finish()
            }

        }
    }

    var isAddedFeed = 0
    private fun showFragment(fragment: Fragment) {
        isAddedFeed++;
        val i= listFragment.indexOf(fragment)
        if(i == 0){
            tvHome.setBackgroundColor(resources.getColor(R.color.red))
            tvPlus.setBackgroundColor(resources.getColor(R.color.white))
            tvPro.setBackgroundColor(resources.getColor(R.color.white))
            tvNoti.setBackgroundColor(resources.getColor(R.color.white))
            tvMess.setBackgroundColor(resources.getColor(R.color.white))
            img_Mess.setImageResource(R.drawable.group_8_white)
            img_Home.setImageResource(R.drawable.group_7)
        } else if(i == 1){
            tvMess.setBackgroundColor(resources.getColor(R.color.red))
            tvHome.setBackgroundColor(resources.getColor(R.color.white))
            tvPlus.setBackgroundColor(resources.getColor(R.color.white))
            tvPro.setBackgroundColor(resources.getColor(R.color.white))
            tvNoti.setBackgroundColor(resources.getColor(R.color.white))
            img_Mess.setImageResource(R.drawable.group_8)
            img_Home.setImageResource(R.drawable.group_7_white)
        }

        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        if (fragment.isAdded) {
            fragmentTransaction.show(fragment)
            listFragment.forEach {
                if (it != fragment) fragmentTransaction.hide(it)
            }
        }
        fragmentTransaction.commit()

    }


    override fun doSomeThing(string: MessContent) {
        var i = -1
        when {
            listFragment[0].isVisible -> {
                showFragment(listFragment[1])
                (listFragment[1] as? MessFragment)?.let {

                    it.list.forEachIndexed { index, messContent ->
                        if (messContent.mID == string.mID)
                            i = index
                    }
                    if(i != -1){
                        it.list.removeAt(i)
                    }
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