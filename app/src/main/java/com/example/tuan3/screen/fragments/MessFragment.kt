package com.example.tuan3.screen.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.Adapters.MessContentAdapter
import com.example.tuan3.R
import com.example.tuan3.data.AppDB
import com.example.tuan3.model.Account
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.activities.ICommunicateFragment
import com.example.tuan3.screen.activities.home
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.fragment_feed.view.*
import kotlinx.android.synthetic.main.fragment_mess.view.*
import kotlinx.coroutines.launch

class MessFragment() : Fragment() {
    var list: ArrayList<MessContent> = ArrayList()
    var mAdapter: MessContentAdapter? = null
    private var appDB: AppDB? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t = inflater.inflate(R.layout.fragment_mess, container, false)
        Log.d("Fragment B", "onCreateViewFragment B")
        return t
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = MessContentAdapter(activity as home)
        Log.d("Fragment B", "onCreateFragment B")
        appDB = AppDB.getDatabase(requireContext())
        list = appDB?.messContentDAO()?.getAllMessContent() as ArrayList<MessContent>

//        list.add(MessContent("Martin Palmer", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 1))
//        list.add(MessContent("Pearl Myers", R.drawable.profile1, "5 : 45 PM", "Hahahaha… \uD83D\uDE02", "", 2))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rvMessContent.layoutManager = LinearLayoutManager(activity)
        view.rvMessContent.adapter = mAdapter
        mAdapter?.setList(list)
        Log.d("Fragment B", "onViewCreated B")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Fragment B", "onAttachFragment B")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("Fragment B", "onActivityCreatedFragment B")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Fragment B", "onStartFragment B")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Fragment B", "onResumeFragment B")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Fragment B", "onPauseFragment B")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Fragment B", "onStopFragment B")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Fragment B", "onDestroyViewFragment B")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Fragment B", "onDestroyFragment B")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Fragment B", "onDetachFragment B")
    }

}