package com.example.rako

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rako.ui.theme.RakoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RakoTheme {
//                RakoNavHost()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RakoTheme {
//        RakoNavHost()
    }
}