package com.example.tuan3.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent

class FeedContentAdapter() : RecyclerView.Adapter<FeedContentAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var feedContents: ArrayList<FeedContent>

    constructor(context: Context, feedContents: ArrayList<FeedContent>) : this() {
        this.context = context
        this.feedContents = feedContents
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avt: ImageView = itemView.findViewById(R.id.imgAvt)
        val name: TextView = itemView.findViewById(R.id.tvName)
        val time : TextView = itemView.findViewById(R.id.tvTime)
        val contentText : TextView = itemView.findViewById(R.id.tvContent)
        val contentImg : ImageView = itemView.findViewById(R.id.imgContent)
        val love : ImageView = itemView.findViewById(R.id.imgLove)
        val cmt : ImageView = itemView.findViewById(R.id.imgCmt)
        val money : TextView = itemView.findViewById(R.id.tvMoney)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val homeView: View = layoutInflater.inflate(R.layout.item_fragment_home, parent, false)
        var viewHoder: ViewHolder= ViewHolder(homeView)
        return viewHoder
    }

    override fun getItemCount(): Int {
        return feedContents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avt.setImageResource(feedContents[position].avt)
        holder.contentImg.setImageResource(feedContents[position].iContent)
        holder.love.setImageResource(feedContents[position].love)
        holder.cmt.setImageResource(feedContents[position].comment)
        holder.name.text= feedContents[position].name
        holder.time.text= feedContents[position].time
        holder.contentText.text= feedContents[position].content
        holder.money.text= feedContents[position].money

        holder.avt.setOnClickListener(){


        }

    }
}