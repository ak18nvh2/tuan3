package com.example.tuan3.Adapters

import android.content.Context
import android.graphics.Color
import android.util.Log.w
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent

class MessContentAdapter() : RecyclerView.Adapter<MessContentAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var messContents : ArrayList<MessContent>

    constructor(context: Context, messContents: ArrayList<MessContent>) : this() {
        this.context = context
        this.messContents = messContents
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avt: ImageView = itemView.findViewById(R.id.imgAvtMess)
        val name: TextView = itemView.findViewById(R.id.tvNameMess)
        val time : TextView = itemView.findViewById(R.id.tvTimeMess)
        val contentText : TextView = itemView.findViewById(R.id.tvContentMess)
        val noti : TextView = itemView.findViewById(R.id.tvNotiMess)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val messView: View = layoutInflater.inflate(R.layout.item_fragment_mess, parent, false)
        var viewHolder: ViewHolder= ViewHolder(messView)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return messContents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avt.setImageResource(messContents[position].avt)
        holder.name.text= messContents[position].name
        holder.time.text= messContents[position].time
        holder.contentText.text= messContents[position].content
        holder.noti.text = messContents[position].noti
        if(messContents[position].noti == "") {
            holder.noti.setBackgroundResource(R.color.w)
            holder.name.setTextColor(Color.parseColor("#161f3d"))
        }


    }
}