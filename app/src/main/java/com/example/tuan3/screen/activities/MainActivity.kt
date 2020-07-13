package com.example.tuan3.screen.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import kotlinx.android.synthetic.main.activity_sign_up.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val db = DBManager(this)
    private val SHARE_PREFERENCES_NAME: String = "account"
    private val TAI_KHOAN: String = "tai_khoan"
    private val MAT_KHAU: String = "mat_khau"
    var check: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        btnSI.setOnClickListener(this)
        tvSU.setOnClickListener(this)
        tv_FP.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        when (v) {
            btnSI -> {

                    check = db.LayTaiKhoanTheoEmail(edtEA_SI.text.toString(), edtPW_SI.text.toString())
                    if (check == 1) {
                        val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
                        val editor: SharedPreferences.Editor = share.edit()
                        editor.putString(TAI_KHOAN, edtEA_SI.text.toString())
                        editor.putString(MAT_KHAU, edtPW_SI.text.toString())
                        editor.apply()
                        val intent: Intent = Intent(this, home::class.java)
                        intent.putExtra("email",edtEA_SI.text.toString())
                        intent.putExtra("pass", edtPW_SI.text.toString())
                        startActivity(intent)
                    }


            }
            tvSU -> {
                val intent: Intent = Intent(this, sign_up::class.java)
                startActivity(intent)
                finish()
            }
            tv_FP -> {
                val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
                startActivity(i2)
            }

        }
    }

    private fun init() {
        val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val name: String? = share.getString(TAI_KHOAN, "")
        val pas: String? = share.getString(MAT_KHAU, "")
        if (pas != "") {
            val intent: Intent = Intent(this, home::class.java)
            intent.putExtra("email",name)
            intent.putExtra("pass", pas)
            startActivity(intent)
        } else {
            val intent = getIntent()
            var tk: String? = intent.getStringExtra("email")
            var mk: String? = intent.getStringExtra("pass")
            if (tk == null) {
                tk = name

            }
            if (mk == null) {
                mk = ""
            }
            edtPW_SI.setText(mk)
            edtEA_SI.setText(tk)

            edtPW_SI.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (edtPW_SI.text.toString().length > 16) {
                        edtPW_SI.setText(edtPW_SI.text.toString().substring(0, edtPW_SI.text.toString().length - 1))
                        edtPW_SI.setSelection(edtPW_SI.text.toString().length)
                        Toast.makeText(this@MainActivity, "Password không được vượt quá 16 ký tự!", Toast.LENGTH_LONG).show()
                    }

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

            })
        }


    }

    private fun quayLaii() {

    }
}