package com.example.explorewise.Navigation

sealed class Route (
    val route : String
){

    data object LoginScreen : Route(route = "loginScreen")

    data object SignupScreen : Route(route = "signupScreen")

    data object LoginSignupScreen : Route(route = "loginSignupScreen")

}