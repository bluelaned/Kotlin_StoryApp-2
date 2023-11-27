package com.bluelaned.storyapp2.data.pref

data class SessionModel(
    val name: String,
    val email: String,
    val token: String,
    val isLogin: Boolean
)