package com.example.myapplication.data

data class ResponseLogin(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: SomeData? //물음표 붙여서 있을수도 없을수도
)

data class SomeData(
    val jwt: String
)