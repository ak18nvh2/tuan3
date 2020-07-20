package com.example.tuan3.screen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.Adapters.MessContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.activities.ICommunicateFragment
import com.example.tuan3.screen.activities.home
import kotlinx.android.synthetic.main.fragment_feed.view.*
import kotlinx.android.synthetic.main.fragment_mess.view.*

class MessFragment() : Fragment() {
    var list: ArrayList<MessContent> = ArrayList()
    var mAdapter: MessContentAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t = inflater.inflate(R.layout.fragment_mess, container, false)
        return t
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = MessContentAdapter(activity as home)
        list.add(MessContent("Martin Palmer", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 1))
        list.add(MessContent("Pearl Myers", R.drawable.profile1, "5 : 45 PM", "Hahahaha… \uD83D\uDE02", "", 2))
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter?.setList(list)
        view.rvMessContent.layoutManager = LinearLayoutManager(activity)
        view.rvMessContent.adapter = mAdapter


    }

}