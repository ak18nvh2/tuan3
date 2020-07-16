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
import com.example.tuan3.Adapters.MessContentAdapter
import com.example.tuan3.R
import com.example.tuan3.model.FeedContent
import com.example.tuan3.model.MessContent

class MessFragment(feedContent: FeedContent?) : Fragment() {
    private var feedContent: FeedContent? = feedContent
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val t = inflater.inflate(R.layout.fragment_mess, container, false)

        var recyclerView: RecyclerView = t.findViewById(R.id.rvMessContent)
        recyclerView.layoutManager = LinearLayoutManager(t.context)
        var arrayList: ArrayList<MessContent> = ArrayList()

        arrayList.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 8))
        arrayList.add(MessContent("Jason Howard", R.drawable.profile, "5 : 45 PM", "Hahahaha… \uD83D\uDE02", "", 9))
        arrayList.add(MessContent("Martin Adele", R.drawable.zoro, "5 : 45 PM", "Sounds perfect to me. \uD83D\uDE0E", "", 5))
        arrayList.add(MessContent("Adelaide Palmer", R.drawable.profile, "5 : 45 PM", "The cost is too high. Can you ple.…", "1", 20))
        arrayList.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "I think, i am gonna go for it. Tha.…", "", 10))
        arrayList.add(MessContent("Jason Howard", R.drawable.profile, "5 : 45 PM", "Ohh yeaah! YOLO!! \uD83D\uDE0D❤️", "", 11))
        arrayList.add(MessContent("Vernon Bradley", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 12))
        arrayList.add(MessContent("Gary Rose", R.drawable.robin, "5 : 45 PM", "Ohh yeaah! YOLO!! \uD83D\uDE0D❤️", "", 3))
        arrayList.add(MessContent("Adelaide Palmer", R.drawable.profile, "5 : 45 PM", "Shall we meet today?", "1", 30))

        var  check : Int = -1
        if (this.feedContent != null) {

            arrayList.forEachIndexed { index, value ->
                if (value.mID == feedContent!!.mID) {
                    Toast.makeText(t.context, "${value.mID} + ${feedContent!!.mID} + $index", Toast.LENGTH_LONG).show()
                    check=index
                }
            }

            arrayList.add(0, MessContent(feedContent!!.name, feedContent!!.avt, "5 : 45 PM", "Shall we meet today?", "1", feedContent!!.mID))
        }
        var adapterMess: MessContentAdapter = MessContentAdapter(t.context, arrayList)
        recyclerView.adapter = adapterMess
        if(check!= -1 ){
            arrayList.removeAt(check)
            adapterMess.notifyItemRemoved(check)
            //Toast.makeText(t.context,"Da xoa $check", Toast.LENGTH_LONG).show()
        }

        return t
    }
}