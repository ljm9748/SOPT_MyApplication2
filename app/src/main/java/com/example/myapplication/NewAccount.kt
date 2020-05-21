package com.example.myapplication

import android.app.Activity
import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.RequestAccount
import com.example.myapplication.data.ResponseAccount
import com.example.myapplication.data.ResponseLogin
import com.example.myapplication.network.RequestToServer
import kotlinx.android.synthetic.main.activity_new_account.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewAccount : AppCompatActivity() {
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)
        button2.setOnClickListener {
            if (makeid.text.isNullOrBlank() || makepw.text.isNullOrBlank() || makename.text.isNullOrBlank() || makeemail.text.isNullOrBlank() || makephone.text.isNullOrBlank()) {
                Toast.makeText(this, "모든 입력란을 채워주세요", Toast.LENGTH_SHORT).show()
            } else {
                //회원가입 요청
                requestToServer.service.requestAccount(
                    RequestAccount(
                        id = makeid.text.toString(),
                        password = makepw.text.toString(),
                        email = makeemail.text.toString(),
                        name = makename.text.toString(),
                        phone = makephone.text.toString()
                    )
                ).enqueue(object : Callback<ResponseAccount> {
                    //callback등록 retrofit의 callback을 import해줘야함
                    override fun onFailure(call: Call<ResponseAccount>, t: Throwable) {
                        //통신 실패
                        Toast.makeText(this@NewAccount, "통신 실패", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<ResponseAccount>, response: Response<ResponseAccount>) {
                        //통신 성공
                        if (response.isSuccessful)//statuscode가 200~300일때 응답 body 이용가능
                            if (response.body()!!.success) {//responselogin의 success가 true인 경우
                                Toast.makeText(this@NewAccount, "회원가입 성공", Toast.LENGTH_SHORT).show()
                                val intent = Intent()
                                intent.putExtra("newid", makeid.text.toString())
                                intent.putExtra("newpw", makepw.text.toString())
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            } else {
                                Toast.makeText(this@NewAccount, "회원가입 실패", Toast.LENGTH_SHORT).show()

                            }

                    }

                })
            }


        }


    }
}
