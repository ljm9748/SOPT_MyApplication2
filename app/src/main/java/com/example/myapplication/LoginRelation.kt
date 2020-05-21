package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.myapplication.data.RequestLogin
import com.example.myapplication.data.ResponseLogin
import com.example.myapplication.network.RequestToServer
import kotlinx.android.synthetic.main.activity_login_relation.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRelation : AppCompatActivity() {
    val requestToServer= RequestToServer//싱글톤 그대로 가져옴
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_relation)

        btn_login.setOnClickListener {
            if(et_email.text.isNullOrBlank() || et_pw.text.isNullOrBlank()){
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }else{
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_email.text.toString(),
                        password = et_pw.text.toString()
                    )//로그인 정보전달
                ).enqueue(object:Callback<ResponseLogin>{//callback등록 retrofit의 callback을 import해줘야함
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                        //통신 실패
                        Toast.makeText(this@LoginRelation,"통신 실패", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                        //통신 성공
                        if (response.isSuccessful)//statuscode가 200~300일때 응답 body 이용가능
                            if(response.body()!!.success){//responselogin의 success가 true인 경우
                                Toast.makeText(this@LoginRelation,"로그인 성공", Toast.LENGTH_SHORT).show()
                                val intent= Intent(this@LoginRelation, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@LoginRelation,"로그인 실패", Toast.LENGTH_SHORT).show()

                            }

                    }

                })



            }
        }
        tv_register.setOnClickListener {
            //val intent= Intent(this, NewAccount::class.java)
            //startActivity(intent)
            var startMainActivityIntent= Intent(this@LoginRelation, NewAccount::class.java)
            startActivityForResult(startMainActivityIntent, 1)
        }


    }

    fun String.toEditable(): Editable=Editable.Factory.getInstance().newEditable(this)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                1->{
                    Toast.makeText(this, "돌아왔습니다.", Toast.LENGTH_SHORT).show()

                    et_email.text=data!!.getStringExtra("newid").toEditable()
                    et_pw.text=data!!.getStringExtra("newpw").toEditable()
                }
            }

        }

    }

}
