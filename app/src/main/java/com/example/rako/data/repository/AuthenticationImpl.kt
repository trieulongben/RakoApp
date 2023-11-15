package com.example.rako.data.repository

import com.example.rako.data.remote.RakoApi
import com.example.rako.data.remote.dto.signin.toDomain
import com.example.rako.data.request.RequestSignIn
import com.example.rako.domain.model.UserDomain
import com.example.rako.domain.repository.AuthenticationRepository
import com.example.rako.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthenticationImpl @Inject constructor(
    val api: RakoApi,
) : AuthenticationRepository {
    override suspend fun signIn(request: RequestSignIn): Flow<Resource<UserDomain>> {
        return flow {
            emit(Resource.Loading())
            val user = api.signIn(request).data?.toDomain()
            user?.let { emit(Resource.Success(it)) }
        }.catch {
            print(it)
        }
    }
}