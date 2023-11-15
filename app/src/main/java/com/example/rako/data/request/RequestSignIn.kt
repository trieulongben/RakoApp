package com.example.rako.data.request

data class RequestSignIn(
    val email: String,
    val password: String,
//    val fcmToken: String,
//    val apnToken: String = ""
)