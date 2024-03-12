package com.example.explorewise.presentation.map

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.explorewise.ui.theme.ExploreWiseTheme


@Composable
fun map(
    navController: NavController
){


}






@Preview
@Composable
fun mapPreview(){
    ExploreWiseTheme {
        map( navController =  rememberNavController() )
    }
}