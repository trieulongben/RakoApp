package com.example.rako.presentation.sign_in

import androidx.lifecycle.viewModelScope
import com.example.rako.base.BaseViewModel
import com.example.rako.data.request.RequestSignIn
import com.example.rako.data.usecase.LoginUseCase
import com.example.rako.util.CachePreferencesHelper
import com.example.rako.util.CoroutineContextProvider
import com.example.rako.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

sealed class SignInState {
    object username : SignInState()
    object password : SignInState()
    object isRemember : SignInState()
    object isSubmitting : SignInState()
    object isError : SignInState()
}

sealed class SignInUiState {
    data class Loading(val isLoading: Boolean = false) : SignInUiState()
    data class Error(var error: String = "") : SignInUiState()
    data class Success(val data: String) : SignInUiState()
}

@HiltViewModel
class SignInViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val preferencesHelper: CachePreferencesHelper,
    private val loginUseCase: LoginUseCase
) : BaseViewModel(contextProvider) {

    private val _loginSuccess = MutableStateFlow<SignInUiState>(SignInUiState.Loading(false))
    val loginSuccess = _loginSuccess.asStateFlow()

    fun signInSubmit(username: String, password: String, isRemember: Boolean) {
        launchCoroutineIO {
            loginUseCase.execute(
                RequestSignIn(
                    email = username,
                    password = password,
                )
            ).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _loginSuccess.value = SignInUiState.Loading(true)
                    }

                    is Resource.Success -> {

                        result.data?.let { loginModel ->

                            preferencesHelper.accessToken = "Bearer " + loginModel.accessToken
                            _loginSuccess.value = SignInUiState.Success(loginModel.accessToken)
                        }
                    }

                    is Resource.Error -> {
                        _loginSuccess.value = SignInUiState.Error(result.message!!)
                    }
                }

            }.launchIn(viewModelScope)
        }
    }
}