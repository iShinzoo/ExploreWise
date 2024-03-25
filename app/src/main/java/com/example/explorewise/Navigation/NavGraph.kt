package com.example.explorewise.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.explorewise.presentation.login_signup.loginScreen
import com.example.explorewise.presentation.login_signup.LoginSignupScreen
import com.example.explorewise.presentation.login_signup.signupScreen
import com.example.explorewise.presentation.map.map


@Composable
fun NavGraph(
){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Route.LoginSignupScreen.route) {

        composable(
            route = Route.LoginSignupScreen.route
        ){
            LoginSignupScreen(navController = navController)
        }

        composable(
            route = Route.LoginScreen.route
        ){
            loginScreen(navController = navController)
        }

        composable(
            route = Route.SignupScreen.route
        ){
            signupScreen(navController = navController)
        }

        composable(
            route = Route.MapScreen.route
        ){
            map(navController = navController)
        }

    }

}