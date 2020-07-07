package com.example.tuan3.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.tuan3.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        ArrayAdapter.createFromResource(
                this,
                R.array.choose_array,
                android.R.layout.simple_spinner_item
        ).also {
            adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = adapter
        }
    }
}