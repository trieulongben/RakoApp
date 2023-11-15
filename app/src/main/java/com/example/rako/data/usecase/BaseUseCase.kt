package com.example.rako.data.usecase

interface BaseUseCase<in Parameter, out Result> {
    suspend fun execute(params: Parameter): Result
}
