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
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_mess.view.*

class MessFragment() : Fragment() {
    val list: ArrayList<MessContent> = ArrayList()
    var mAdapter: MessContentAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t = inflater.inflate(R.layout.fragment_mess, container, false)
        return t
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = MessContentAdapter(activity as home)
        list.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 8))
        list.add(MessContent("Jason Howard", R.drawable.profile, "5 : 45 PM", "Hahahaha… \uD83D\uDE02", "", 9))
        list.add(MessContent("Martin Adele", R.drawable.zoro, "5 : 45 PM", "Sounds perfect to me. \uD83D\uDE0E", "", 5))
        list.add(MessContent("Adelaide Palmer", R.drawable.profile, "5 : 45 PM", "The cost is too high. Can you ple.…", "1", 20))
        list.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "I think, i am gonna go for it. Tha.…", "", 10))
        list.add(MessContent("Jason Howard", R.drawable.profile, "5 : 45 PM", "Ohh yeaah! YOLO!! \uD83D\uDE0D❤️", "", 11))
        list.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 12))
        list.add(MessContent("Gary Rose", R.drawable.robin, "5 : 45 PM", "Ohh yeaah! YOLO!! \uD83D\uDE0D❤️", "", 3))
        list.add(MessContent("Adelaide Palmer", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 30))

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.rvMessContent.layoutManager = LinearLayoutManager(activity)
        view.rvMessContent.adapter = mAdapter
        mAdapter?.setList(list)

    }

}