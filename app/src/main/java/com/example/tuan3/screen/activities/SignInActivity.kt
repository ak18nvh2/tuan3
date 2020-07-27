package com.example.tuan3.screen.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tuan3.R
import com.example.tuan3.data.AppDB
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity(), View.OnClickListener {
    var check: Int = 0
    private var appDB: AppDB? = null

    companion object {
        val REQUEST_FROM_SIGNIN_TO_SIGNUP = 1
        val SHARE_PREFERENCES_NAME: String = "account"
        val EMAIL: String = "Email"
        val PASSWORD: String = "Password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
    }

    override fun onClick(v: View) {
        when (v) {
            btn_SignIn -> {
                // check = db.LayTaiKhoanTheoEmail(edt_EmailAddressSignIn.text.toString(), edt_PassWordSignIn.text.toString())
                appDB = AppDB.getDatabase(this)
                var account = appDB?.accountDAO()?.getAccByEmail(edt_EmailAddressSignIn.text.toString())
                if (account == null) {
                    check = 1 // don't have this email in database
                } else {
                    if (account.passWord != edt_PassWordSignIn.text.toString()) {
                        check = 2 // have this email in database but password incorrect
                    } else {
                        check = 3 // corecct email and password
                    }
                }
                if (check == 1) {
                    Toast.makeText(this, "Không tồn tại tài khoản này!", Toast.LENGTH_SHORT).show()
                } else if (check == 2) {
                    Toast.makeText(this, "Sai mật khẩu!", Toast.LENGTH_SHORT).show()
                } else if (check == 3) {
                    val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = share.edit()
                    editor.putString(EMAIL, edt_EmailAddressSignIn.text.toString())
                    editor.putString(PASSWORD, edt_PassWordSignIn.text.toString())
                    editor.apply()
                    val intent: Intent = Intent(this, home::class.java)
                    startActivity(intent)
                    finish()
                }


            }
            tv_SignUp -> {
                val intent: Intent = Intent(this, SignUpActivity::class.java)
                startActivityForResult(intent, REQUEST_FROM_SIGNIN_TO_SIGNUP)
            }
            tv_ForgotPassword -> {
                val i2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
                startActivity(i2)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_FROM_SIGNIN_TO_SIGNUP) {
            if (resultCode == Activity.RESULT_OK) {
                edt_EmailAddressSignIn.setText(data?.getStringExtra(EMAIL))
                edt_PassWordSignIn.setText(data?.getStringExtra(PASSWORD))
            }
        }
    }

    private fun init() {
        val share: SharedPreferences = getSharedPreferences(SHARE_PREFERENCES_NAME, Context.MODE_PRIVATE)
        val acc : String? = share.getString(EMAIL,"")
        val pass: String? = share.getString(PASSWORD, "")
        if (pass != "") {
            val intent: Intent = Intent(this, home::class.java)
            startActivity(intent)
            finish()
        }
        btn_SignIn.setOnClickListener(this)
        tv_SignUp.setOnClickListener(this)
        tv_ForgotPassword.setOnClickListener(this)
    }

}