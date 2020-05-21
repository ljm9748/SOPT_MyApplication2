package com.example.myapplication.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



object RequestToServer{//오브젝트는 객체가 하나만있는 싱글톤
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}