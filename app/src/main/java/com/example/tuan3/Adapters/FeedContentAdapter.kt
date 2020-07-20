package com.example.tuan3.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.activities.ICommunicateFragment

class FeedContentAdapter(var listener: ICommunicateFragment, var mContext: Context) : RecyclerView.Adapter<FeedContentAdapter.ViewHolder>() {

    private var list = ArrayList<FeedContent>()

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
    fun  setList(list : ArrayList<FeedContent>){
        this.list = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val homeView: View = layoutInflater.inflate(R.layout.item_fragment_feed, parent, false)
        return ViewHolder(homeView)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avt.setImageResource(list[position].avt)
        holder.contentImg.setImageResource(list[position].iContent)
        holder.love.setImageResource(list[position].love)
        holder.cmt.setImageResource(list[position].comment)
        holder.name.text= list[position].name
        holder.time.text= list[position].time
        holder.contentText.text= list[position].content
        holder.money.text= list[position].money
        var doiTuong = MessContent( list[position].name, list[position].avt, "Yesterday",
        "Contenttt", "2" , list[position].mID)
        holder.avt.setOnClickListener(){
            listener.doSomeThing(doiTuong)
        }

    }

}