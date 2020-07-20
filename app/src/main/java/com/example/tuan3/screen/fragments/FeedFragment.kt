package com.example.tuan3.screen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuan3.Adapters.FeedContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.screen.activities.home
import kotlinx.android.synthetic.main.fragment_feed.view.*


class FeedFragment() : Fragment() {
    val list: ArrayList<FeedContent> = ArrayList()
    var mAdapter: FeedContentAdapter? = null
    val types = arrayOf("All Categories", "Admin")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val t = inflater.inflate(R.layout.fragment_feed, container, false)
        val spinner = t.findViewById<Spinner>(R.id.sp1)
        spinner?.adapter = ArrayAdapter(activity!!.applicationContext, R.layout.support_simple_spinner_dropdown_item, types) as SpinnerAdapter
        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val type = parent?.getItemAtPosition(position).toString()
            }
        }

        return t
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = FeedContentAdapter(activity as home, requireActivity())
        list.add(FeedContent("Martin Palmer", R.drawable.profile, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0, R.drawable.heart, R.drawable.comment_1, "$340.00", 1))
        list.add(FeedContent("Pearl Myers", R.drawable.profile1, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$240.00", 2))
        list.add(FeedContent("Gary Rose", R.drawable.profile2, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$1940.00", 3))
        list.add(FeedContent("Adelaide Palmer", R.drawable.profile3, "Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$3420.00", 4))
        list.add(FeedContent("Martin Adele", R.drawable.profile4, "Today, 03:24 PM",
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….",
                0, R.drawable.heart_pink, R.drawable.comment_1, "$3140.00", 5))
        list.add(FeedContent("Beatrix Palmer", R.drawable.profile5, "Today, 03:24 PM",
                "There is this awesome event happening. Let’s join it guys.",
                R.drawable.rectangle_copy, R.drawable.heart_pink, R.drawable.comment_1, "$3640.00", 6))
        list.add(FeedContent("Martin Belinda", R.drawable.profile6, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 7))
        list.add(FeedContent("Martin Belinda", R.drawable.profile7, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 8))
        list.add(FeedContent("Martin Belinda", R.drawable.profile8, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 9))
        list.add(FeedContent("Martin Belinda", R.drawable.profile9, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 10))
        list.add(FeedContent("Martin Belinda", R.drawable.profile10, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.sanji, R.drawable.heart, R.drawable.comment_1, "$3540.00", 11))
        list.add(FeedContent("Martin Belinda", R.drawable.profile11, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 12))
        list.add(FeedContent("Martin Belinda", R.drawable.profile12, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.chopper, R.drawable.heart, R.drawable.comment_1, "$3540.00", 13))
        list.add(FeedContent("Martin Belinda", R.drawable.profile13, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 14))
        list.add(FeedContent("Martin Belinda", R.drawable.profile14, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 15))
        list.add(FeedContent("Martin Belinda", R.drawable.profile15, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.zoro, R.drawable.heart, R.drawable.comment_1, "$3540.00", 16))
        list.add(FeedContent("Martin Belinda", R.drawable.profile16, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 17))
        list.add(FeedContent("Martin Belinda", R.drawable.profile17, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.robin, R.drawable.heart, R.drawable.comment_1, "$3540.00", 18))
        list.add(FeedContent("Martin Belinda", R.drawable.profile18, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 19))
        list.add(FeedContent("Martin Belinda", R.drawable.profile19, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.rectangle_copy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 20))
        list.add(FeedContent("Martin Belinda", R.drawable.profile20, "Today, 03:24 PM",
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                R.drawable.luffy, R.drawable.heart, R.drawable.comment_1, "$3540.00", 21))

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter?.setList(list)
        view.rvFeedContent.layoutManager = LinearLayoutManager(activity)
        view.rvFeedContent.adapter = mAdapter


    }


}