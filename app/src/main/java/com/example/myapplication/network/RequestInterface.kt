package com.example.myapplication.network

import com.example.myapplication.data.RequestAccount
import com.example.myapplication.data.RequestLogin
import com.example.myapplication.data.ResponseAccount
import com.example.myapplication.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body: RequestLogin): Call<ResponseLogin>
    @POST("/user/signup")
    fun requestAccount(@Body body: RequestAccount): Call<ResponseAccount>
}