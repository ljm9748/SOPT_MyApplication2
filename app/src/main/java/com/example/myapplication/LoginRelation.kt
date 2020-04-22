package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_relation.*
import kotlinx.android.synthetic.main.login_used.*

class LoginRelation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_relation)
        //
        btn_login.setOnClickListener {
            if(et_email.text.isNullOrBlank() || et_pw.text.isNullOrBlank()){
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        tv_register.setOnClickListener {
            val intent= Intent(this, NewAccount::class.java)
            startActivity(intent)
        }


    }


}
