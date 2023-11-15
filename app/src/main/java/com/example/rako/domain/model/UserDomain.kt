package com.example.rako.domain.model

data class UserDomain(
    val avatar: String,
    val name: String,
    val userName: String,
    val userType: String,
    val role: String,
    val isActive: Boolean,
    val id: String,
    val accessToken: String
) {
    fun empty(): UserDomain {
        return UserDomain(
            avatar = "",
            name = "",
            userName = "",
            userType = "",
            role = "",
            isActive = false,
            id = "",
            accessToken = ""
        )
    }
}
