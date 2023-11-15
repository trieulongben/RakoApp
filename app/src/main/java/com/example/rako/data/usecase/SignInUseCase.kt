package com.example.rako.data.usecase

import com.example.rako.data.request.RequestSignIn
import com.example.rako.domain.model.UserDomain
import com.example.rako.domain.repository.AuthenticationRepository
import com.example.rako.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias LoginBaseUseCase = BaseUseCase<RequestSignIn, Flow<Resource<UserDomain>>>

class LoginUseCase @Inject constructor(
    private val rakoRepository: AuthenticationRepository
) : LoginBaseUseCase {
    override suspend fun execute(params: RequestSignIn) = rakoRepository.signIn(params)
}