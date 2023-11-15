package com.example.rako.domain.repository

import com.example.rako.data.request.RequestSignIn
import com.example.rako.domain.model.UserDomain
import com.example.rako.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {

    suspend fun signIn(
        request: RequestSignIn
    ): Flow<Resource<UserDomain>>

}