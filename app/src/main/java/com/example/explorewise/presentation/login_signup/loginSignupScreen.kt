package com.example.explorewise.presentation.login_signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.explorewise.Navigation.Route
import com.example.explorewise.R
import com.example.explorewise.ui.theme.ExploreWiseTheme
import com.example.explorewise.ui.theme.headingFamily


@Composable
fun loginSignupScreen(
    navController: NavController
){



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ){


        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = " Welcome to ExploreWise",
                modifier = Modifier.padding(top = 120.dp),
                color = colorResource(id = R.color.textColor),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = headingFamily
            )

            Spacer(modifier = Modifier.height(40.dp))


            Text(
                text = "Don't Wait",
                modifier = Modifier,
                color = colorResource(id = R.color.textColor),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Get best experience now!",
                modifier = Modifier,
                color = colorResource(id = R.color.textColor),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.explore),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                contentScale = ContentScale.Fit
            )


            Spacer(modifier = Modifier.height(40.dp))

            ElevatedButton(
                onClick = {
                          navController.navigate(route = Route.LoginScreen.route)
                },
                modifier = Modifier.width(400.dp),
                colors = ButtonDefaults.elevatedButtonColors(colorResource(id = R.color.textColor))
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = headingFamily
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate(route = Route.SignupScreen.route)
                },
                modifier = Modifier.width(400.dp),
                border = BorderStroke( width = 2.dp , color = colorResource(id = R.color.textColor))
                ) {
                Text(
                    text = "Don't have an Account? SignUP",
                    modifier = Modifier,
                    color = colorResource(id = R.color.textColor),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = headingFamily
                )
            }

        }

    }
}


@Preview
@Composable
fun loginSignupScreenPreview(){
    ExploreWiseTheme {
        loginSignupScreen( navController =  rememberNavController())
    }
}