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


class HomeFragment(val adapter: FeedContentAdapter): Fragment() {
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
        recyclerView.adapter= adapter
        return t
}




}