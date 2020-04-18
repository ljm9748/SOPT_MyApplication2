package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun main(){
        mul(1,3)
        var name = "정민"
        Log.d("printnume", "${name}")
    }

    fun mul(a:Int, b:Int):Int{
        val ans: Int =a*b
        Log.d("print","a*b의 값은: ${a*b} ")
        return a*b
    }
}
