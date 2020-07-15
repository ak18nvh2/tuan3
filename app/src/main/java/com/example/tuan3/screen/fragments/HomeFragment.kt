package com.example.tuan3.screen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment: Fragment() {
    val types = arrayOf("All Categories", "Admin")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t  =inflater.inflate(R.layout.fragment_home, container, false )
        val spinner = t.findViewById<Spinner>(R.id.sp1)
        spinner?.adapter = ArrayAdapter(activity!!.applicationContext, R.layout.support_simple_spinner_dropdown_item, types) as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
            }
        }


        var recyclerView: RecyclerView = t.findViewById(R.id.rvFeedContent)
        recyclerView.layoutManager= LinearLayoutManager(t.context)

        var arrayList: ArrayList<FeedContent> = ArrayList()

        arrayList.add( FeedContent("Martin Palmer",R.drawable.profile,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0,R.drawable.heart, R.drawable.comment_1,"$340.00"))
        arrayList.add( FeedContent("Pearl Myers",R.drawable.rectangle_copy,"Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$240.00"))
        arrayList.add( FeedContent("Gary Rose",R.drawable.robin,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                R.drawable.rectangle_copy,R.drawable.heart, R.drawable.comment_1,"$1940.00"))
        arrayList.add( FeedContent("Adelaide Palmer",R.drawable.luffy,"Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$3420.00"))
        arrayList.add( FeedContent("Martin Adele",R.drawable.zoro,"Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
               0,R.drawable.heart_pink, R.drawable.comment_1,"$3140.00"))
        arrayList.add( FeedContent("Beatrix Palmer",R.drawable.chopper,"Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy,R.drawable.heart_pink, R.drawable.comment_1,"$3640.00"))
        arrayList.add( FeedContent("Martin Belinda",R.drawable.sanji,"Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy,R.drawable.heart, R.drawable.comment_1,"$3540.00"))


        var adapterHome: FeedContentAdapter = FeedContentAdapter(t.context,arrayList)
        recyclerView.adapter= adapterHome


        return t

}}