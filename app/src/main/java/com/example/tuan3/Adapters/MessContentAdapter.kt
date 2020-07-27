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
import com.example.tuan3.data.AppDB
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent
import com.example.tuan3.screen.activities.ICommunicateFragment

class MessContentAdapter(var mContext: Context) : RecyclerView.Adapter<MessContentAdapter.ViewHolder>() {


    private var list = ArrayList<MessContent>()
    private var appDB: AppDB? = null
    fun setList(list: ArrayList<MessContent>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avt: ImageView = itemView.findViewById(R.id.imgAvtMess)
        val name: TextView = itemView.findViewById(R.id.tvNameMess)
        val time : TextView = itemView.findViewById(R.id.tvTimeMess)
        val contentText : TextView = itemView.findViewById(R.id.tvContentMess)
        val noti : TextView = itemView.findViewById(R.id.tvNotiMess)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val messView: View = layoutInflater.inflate(R.layout.item_fragment_mess, parent, false)
        return ViewHolder(messView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avt.setImageResource(list[position].avt)
        holder.name.text= list[position].name
        holder.time.text= list[position].time
        holder.contentText.text= list[position].content
        holder.noti.text = list[position].noti
        if(list[position].noti == "") {
            holder.noti.setBackgroundResource(R.color.w)
            holder.name.setTextColor(Color.parseColor("#161f3d"))
        }
        else {
            holder.name.setTextColor(Color.parseColor("#e9446a"))
            holder.noti.setBackgroundResource(R.drawable.circle_text_noti_mess)
        }
        appDB = AppDB.getDatabase(mContext)
        holder.avt.setOnClickListener(){
            appDB?.messContentDAO()?.deleteByID(list[position].mID)
            this.list.clear()
            this.list = appDB?.messContentDAO()?.getAllMessContent() as ArrayList<MessContent>
            this.setList(this.list)
        }
    }
}