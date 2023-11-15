package com.example.rako.presentation.sign_in

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rako.components.CButton
import com.example.rako.components.CCheckBox
import com.example.rako.components.CCheckBoxState
import com.example.rako.components.TextFieldState
import com.example.rako.components.TextInput

@Composable
fun SignInView(
    viewModel:SignInViewModel
) {

    val username = remember { TextFieldState() }
    val password = remember { TextFieldState() }
    val isRemember = remember { CCheckBoxState() }

    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Column(
                Modifier
                    .width(265.dp),
                content = {
                    TextInput(
                        label = "Username",
                        placeholder = "Input your username",
                        state = username
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextInput(
                        label = "Password",
                        placeholder = "Input your password",
                        state = password,
                        isPassword = true
                    )
                    CCheckBox(label = "remember account", state = isRemember)
                    Column(
                        Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {
                            CButton(label = "Sign-In", onPress = {
                              viewModel.signInSubmit(username.text,password.text,isRemember.isChecked)
                            })
                        }
                    )
                }
            )

        }
    )
}
