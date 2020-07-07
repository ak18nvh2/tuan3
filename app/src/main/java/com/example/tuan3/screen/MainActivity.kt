package com.example.tuan3.screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tuan3.R
import com.example.tuan3.data.DBManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val db = DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btnSI.setOnClickListener(this)
        tvSU.setOnClickListener(this)



    }
    override fun  onClick(v: View){

        when(v){
            btnSI -> {
                val check : Int = db.LayTaiKhoanTheoEmail(edtEA_SI.text.toString(), edtPW_SI.text.toString())
                if (check==1){
                    val  intent : Intent = Intent(this, RecyclerView::class.java)
                    startActivity(intent)
                }
            }
            tvSU ->  ChuyenSangManHinhDangKy()
            tv_FP -> {
                val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=yourpackagename"))
                startActivity(i2)
            }

        }
    }
   private fun ChuyenSangManHinhDangKy(){
        val intent : Intent = Intent(this, sign_up::class.java)
        startActivity(intent)
        finish()
        
    }
    private fun init(){
        val intent = getIntent()
        var tk : String? = intent.getStringExtra("email")
        var mk : String? = intent.getStringExtra("pass")
        if(tk == null){
            tk = "olson.minnie@ellen.biz"
        }
        if(mk == null){
            mk= "1223243543254"
        }
        edtPW_SI.setText(mk)
        edtEA_SI.setText(tk)

        edtPW_SI.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(edtPW_SI.text.toString().length > 16){
                    edtPW_SI.setText(edtPW_SI.text.toString().substring(0, edtPW_SI.text.toString().length-1))
                    edtPW_SI.setSelection(edtPW_SI.text.toString().length)
                    Toast.makeText(this@MainActivity, "Password không được vượt quá 16 ký tự!",Toast.LENGTH_LONG).show()
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
    private  fun quayLaii(){

    }
}