package com.example.rako.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rako.R

@Composable
fun TextInput(
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    state: TextFieldState = TextFieldState(),
    isPassword: Boolean = false,
    numberOfLines: Int = 1,
) {

    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(Dp(4.0F)))
        TextField(
            value = state.text, onValueChange = { state.text = it },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            visualTransformation = if (state.isShowPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                isPassword.let {
                    if (it) {
                        Button(
                            onClick = { state.isShowPassword = !state.isShowPassword },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.Transparent

                            ),
                        )


                        {
                            state.isShowPassword.let {
                                if (it) {
                                    Icon(
                                        painter = painterResource(
                                            R.drawable.password_show
                                        ), contentDescription = "Password Show",
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp)
                                    )
                                } else {
                                    Icon(
                                        painter = painterResource(
                                            R.drawable.password_hide
                                        ),
                                        contentDescription = "Password Show",
                                        modifier = Modifier
                                            .width(20.dp)
                                            .height(20.dp),

                                        )
                                }
                            }
                        }
                    } else {
                        null
                    }

                }
            },
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
            },
            textStyle = TextStyle(
                fontSize = 12.91.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(300),
                color = Color.Black,
            ),
            modifier = Modifier
                .border(
                    width = 0.5534.dp,
                    color = Color(0xFFA8A8A8),
                    shape = RoundedCornerShape(size = 5.53402.dp)
                )
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 5.53402.dp)
                ),
            maxLines = numberOfLines
        )
    }

}
