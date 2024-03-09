package com.example.explorewise.presentation.login_signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
fun loginScreen(
    navController: NavController
) {


    // remember keyword is used to store/remember the value in case recompose is called
    // mutableStateOf() is used to state that the value can be changed

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordHidden by remember { mutableStateOf(true) }



    Box(modifier = Modifier
        .background(Color.White)){



        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            contentScale = ContentScale.Fit
        )



        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {



            Text(
                text = "ExploreWise",
                modifier = Modifier.padding(top = 180.dp),
                color = colorResource(id = R.color.textColor),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = headingFamily
            )



            Spacer(modifier = Modifier.height(30.dp))



            OutlinedTextField(
                modifier = Modifier.width(300.dp),

                value = email,

                onValueChange = {email = it},

                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null)
                },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),

                placeholder = {
                    Text(text = "Email",
                        color = colorResource(id = R.color.textColor)
                    )},

                singleLine = true
                )



            Spacer(modifier = Modifier.height(18.dp))



            OutlinedTextField(
                modifier = Modifier.width(300.dp),

                value = password,

                onValueChange = {password = it},

                placeholder = {
                    Text(text = "Password",
                        color = colorResource(id = R.color.textColor)
                    )},

                singleLine = true,

                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = null)
                },

                trailingIcon =  {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {

                        val visibilityIcon =

                            if (passwordHidden) Icons.Default.VisibilityOff else Icons.Default.Visibility

                        val description = if (passwordHidden)  "Show Password" else "Hide Password"

                        Icon(imageVector = visibilityIcon, contentDescription = description)

                    }
                },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                ),

                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None

                // visual Transformation is used for formatting and transforimg Textfeild input
            )




            Spacer(modifier = Modifier.height(18.dp))




            ElevatedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(300.dp),
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
                    navController.navigate(route = Route.SignupScreen.route){
                        popUpTo(Route.LoginSignupScreen.route)
                    }
                },
                modifier = Modifier.width(300.dp),
                border = BorderStroke( width = 2.dp , color = colorResource(id = R.color.textColor))
            ) {
                Text(
                    text = "Don't have an Account? SignUP",
                    modifier = Modifier,
                    color = colorResource(id = R.color.textColor),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = headingFamily
                )
            }



            Spacer(modifier = Modifier.height(12.dp))



            Text(
                text = "-------------------OR---------------------",
                modifier = Modifier,
                color = colorResource(id = R.color.textColor),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )



            Spacer(modifier = Modifier.height(12.dp))


            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(300.dp),
                border = BorderStroke( width = 2.dp , color = colorResource(id = R.color.textColor))
            ) {



                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 6.dp),
                    contentScale = ContentScale.Fit
                )


                
                Text(
                    text = "SignIn with Google",
                    modifier = Modifier,
                    color = colorResource(id = R.color.textColor),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = headingFamily
                )
            }

            OutlinedButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(300.dp),
                border = BorderStroke( width = 2.dp , color = colorResource(id = R.color.textColor))
            ) {



                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 6.dp),
                    contentScale = ContentScale.Fit
                )



                Text(
                    text = "SignIn with Facebook",
                    modifier = Modifier,
                    color = colorResource(id = R.color.textColor),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = headingFamily
                )
            }
        }
    }

}


@Preview
@Composable
fun loginScreenPreview(){
    ExploreWiseTheme {
        loginScreen( navController =  rememberNavController())
    }
}