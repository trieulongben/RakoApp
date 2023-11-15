package com.example.rako

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rako.presentation.sign_in.SignInRoute

object Destinations {
    const val SIGN_IN_ROUTE = "signin"

}

@Composable
fun RakoNavHost(
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        navController = navController,
        startDestination = Destinations.SIGN_IN_ROUTE,
    ) {
        composable(Destinations.SIGN_IN_ROUTE) {

            SignInRoute(
                onSignInSuccessfully ={
                    navController.navigate("signup/")
                },
                onNavToForgetPassword = {
                    navController.navigate("signup/")
                },
                onNavToSignUp = {
                    navController.navigate("signup/")
                }
            )
        }

    }
}