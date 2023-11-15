package com.example.rako.data.remote

import com.example.rako.base.BaseResponse
import com.example.rako.data.remote.dto.signin.SignInDto
import com.example.rako.data.request.RequestSignIn
import retrofit2.http.Body
import retrofit2.http.POST


interface RakoApi {

    @POST("sign-in")
    suspend fun signIn(
        @Body request: RequestSignIn
    ): BaseResponse<SignInDto>

}