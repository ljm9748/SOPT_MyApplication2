package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_account.*


class NewAccount : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)
        button2.setOnClickListener {
            if (editText3.text.isNullOrBlank() || editText4.text.isNullOrBlank() || editText5.text.isNullOrBlank() || editText6.text.isNullOrBlank()){
                Toast.makeText(this, "모든 입력란을 채워주세요", Toast.LENGTH_SHORT).show()

            }else{
                val intent = Intent()
                intent.putExtra("newid", editText3.text.toString())
                intent.putExtra("newpw", editText4.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }


    }


}
