package com.example.tuan3.screen.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.tuan3.R
import com.example.tuan3.data.DBManager
import com.example.tuan3.model.TaiKhoan
import kotlinx.android.synthetic.main.activity_sign_up.*


class Sign_up_Activity : AppCompatActivity(), View.OnClickListener {
    val db = DBManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }

    fun taiKhoan(): TaiKhoan {
        return TaiKhoan(edt_FN.text.toString(), edt_EM_SU.text.toString(), edt_PW.text.toString())
    }

    private fun init() {
        var taiKhoan =
                btn_SU.setOnClickListener(this)
        tvSI.setOnClickListener(this)
        btnQuayLai_su.setOnClickListener(this)
        edt_PW.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (edt_PW.text.toString().length > 16) {
                    edt_PW.setText(edt_PW.text.toString().substring(0, edt_PW.text.toString().length - 1))
                    edt_PW.setSelection(edt_PW.text.toString().length)
                    Toast.makeText(this@Sign_up_Activity, "Password không được vượt quá 16 ký tự!", Toast.LENGTH_LONG).show()
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    override fun onClick(v: View) {
        when (v) {
            btnQuayLai_su -> ChuyenSangManHinhDangNhap()
            tvSI -> ChuyenSangManHinhDangNhap()
            btn_SU -> DangKy()
        }
    }

    fun DangKy() {
        if (validate()) {
            val check = db.themTaiKhoan(taiKhoan())
            if (check == 1) {
                val intent: Intent = Intent(this, MainActivity::class.java)
                intent.putExtra("email", edt_EM_SU.text.toString())
                intent.putExtra("pass", edt_PW.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }

    fun ChuyenSangManHinhDangNhap() {
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun validate(): Boolean {
        var pattenFullName = Regex("[A-Za-z ]+")
        var pattenPassWord = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$")
        var pattenEmail = Regex("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]+")
        if (!pattenFullName.containsMatchIn(edt_FN.text.toString())) {
            edt_FN.error = "Không được để trống!"
            return false
        } else if (edt_EM_SU.text.toString().isEmpty()) {
            edt_EM_SU.error = "Không được để trống!"
            return false
        } else if (!pattenEmail.containsMatchIn(edt_EM_SU.text.toString())) {
            edt_EM_SU.error = "Cần nhập đúng định dạng email!"
            return false
        } else if (edt_PW.text.toString().isEmpty()) {
            edt_PW.error = "Không được để trống!"
            return false
        } else if (!pattenPassWord.containsMatchIn(edt_PW.text.toString())) {
            edt_PW.error = "Mật khẩu phải có cả chữ hoa, chữ thường, số và dài từ 8 đến 16 ký tự"
            return false
        }
        return true
    }
}