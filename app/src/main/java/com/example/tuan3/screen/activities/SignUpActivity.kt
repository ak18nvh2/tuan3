package com.example.tuan3.screen.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.tuan3.R
import com.example.tuan3.data.AppDB
import com.example.tuan3.model.Account
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class SignUpActivity : AppCompatActivity(), View.OnClickListener, CoroutineScope {

    private var appDB: AppDB? = null
    var check = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()
    }


    private fun init() {

        btn_SU.setOnClickListener(this)
        tv_SI.setOnClickListener(this)
        btnQuayLai_su.setOnClickListener(this)

        edt_PW.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (edt_PW.text.toString().length > 16) {
                    edt_PW.setText(edt_PW.text.toString().substring(0, edt_PW.text.toString().length - 1))
                    edt_PW.setSelection(edt_PW.text.toString().length)
                    Toast.makeText(this@SignUpActivity, "Password không được vượt quá 16 ký tự!", Toast.LENGTH_LONG).show()
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
            tv_SI -> returnSignInActivity()
            btn_SU -> registerAccount()
        }
    }

    fun registerAccount() {
        if (checkValidate()) {
            appDB = AppDB.getDatabase(this)
            var account = appDB?.accountDAO()?.getAccByEmail(edt_EM.text.toString())
            if (account == null) check = 1
            if (check == 0) Toast.makeText(this, "Đã tồn tại tài khoản này!", Toast.LENGTH_SHORT).show()
            else if (check == 1) {

                launch {
                    appDB?.accountDAO()?.addAccount(Account(edt_EM.text.toString(), edt_FN.text.toString(), edt_PW.text.toString()))
                }

                val intent: Intent = Intent()
                intent.putExtra(SignInActivity.EMAIL, edt_EM.text.toString())
                intent.putExtra(SignInActivity.PASSWORD, edt_PW.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }
    }

    fun returnSignInActivity() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    private fun checkValidate(): Boolean {
        val pattenFullName = Regex("[A-Za-z ]+")
        val pattenPassWord = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$")
        val pattenEmail = Regex("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]+")
        if (!pattenFullName.containsMatchIn(edt_FN.text.toString())) {
            edt_FN.error = "Không được để trống!"
            return false
        } else if (edt_EM.text.toString().isEmpty()) {
            edt_EM.error = "Không được để trống!"
            return false
        } else if (!pattenEmail.containsMatchIn(edt_EM.text.toString())) {
            edt_EM.error = "Cần nhập đúng định dạng email!"
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

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}