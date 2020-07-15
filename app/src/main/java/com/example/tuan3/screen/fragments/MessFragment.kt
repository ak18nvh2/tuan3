package com.example.tuan3.screen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.Adapters.MessContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent

class MessFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t  =inflater.inflate(R.layout.fragment_mess, container, false )

        var recyclerView: RecyclerView = t.findViewById(R.id.rvMessContent)
        recyclerView.layoutManager= LinearLayoutManager(t.context)
        var arrayList: ArrayList<MessContent> = ArrayList()
        arrayList.add(MessContent("Vernon Bradley",R.drawable.profile, "5 : 45 PM","Shall we meet today?","1"))
        arrayList.add(MessContent("Jason Howard",R.drawable.profile, "5 : 45 PM","Hahahaha… \uD83D\uDE02",""))
        arrayList.add(MessContent("Beatrix Palmer",R.drawable.profile, "5 : 45 PM","Sounds perfect to me. \uD83D\uDE0E",""))
        arrayList.add(MessContent("Adelaide Palmer",R.drawable.profile, "5 : 45 PM","The cost is too high. Can you ple.…","1"))
        arrayList.add(MessContent("Vernon Bradley",R.drawable.profile, "5 : 45 PM","I think, i am gonna go for it. Tha.…",""))
        arrayList.add(MessContent("Jason Howard",R.drawable.profile, "5 : 45 PM","Ohh yeaah! YOLO!! \uD83D\uDE0D❤️",""))
        arrayList.add(MessContent("Vernon Bradley",R.drawable.profile, "5 : 45 PM","Shall we meet today?","1"))
        arrayList.add(MessContent("Beatrix Palmer",R.drawable.profile, "5 : 45 PM","Ohh yeaah! YOLO!! \uD83D\uDE0D❤️",""))
        arrayList.add(MessContent("Adelaide Palmer",R.drawable.profile, "5 : 45 PM","Shall we meet today?","1"))


        var adapterMess: MessContentAdapter = MessContentAdapter(t.context,arrayList)
        recyclerView.adapter= adapterMess

        return t
    }
}