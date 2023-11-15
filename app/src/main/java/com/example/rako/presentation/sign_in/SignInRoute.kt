package com.example.rako.presentation.sign_in

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SignInRoute(
    onSignInSuccessfully: () -> Unit,
    onNavToSignUp: () -> Unit,
    onNavToForgetPassword: () -> Unit,
) {
    val signInViewModel: SignInViewModel=hiltViewModel()
    SignInView(
        viewModel= signInViewModel
    )
}