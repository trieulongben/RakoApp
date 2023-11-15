package com.example.rako.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rako.R

@Composable
fun CButton(
    label: String,
    onPress: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { onPress() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFDC4534),
        ),
        shape = RoundedCornerShape(size = 5.53402.dp),
    ) {

        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.76.sp,
                fontFamily = FontFamily(Font(R.font.poppins)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
            )

        )

    }
}