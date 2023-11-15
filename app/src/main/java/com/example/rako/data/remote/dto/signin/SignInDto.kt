package com.example.rako.data.remote.dto.signin

import com.example.rako.domain.model.UserDomain

data class SignInDto(
    val avatar: String,
    val name: String,
    val userName: String,
    val userType: String,
    val role: String,
    val isActive: Boolean,
    val id: String,
    val accessToken: String
)


fun SignInDto.toDomain(): UserDomain {
    return UserDomain(
        avatar = this.avatar,
        name = this.name,
        userName = this.userName,
        userType = this.userType,
        role = this.role,
        isActive = this.isActive,
        id = this.id,
        accessToken = this.accessToken
    )
}