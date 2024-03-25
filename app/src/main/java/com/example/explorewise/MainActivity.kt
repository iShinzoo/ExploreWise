package com.example.explorewise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.explorewise.Navigation.NavGraph
import com.example.explorewise.presentation.login_signup.loginScreen
import com.example.explorewise.ui.theme.ExploreWiseTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // WindowCompat.setDecorFitsSystemWindows(window,false) is used to allow to disable the navigation of
        // a device

        WindowCompat.setDecorFitsSystemWindows(window, false)



        // splash screen
        installSplashScreen()

        setContent {
            ExploreWiseTheme {

                // sideEffect(setStatusBarColor) is used to customize the status bar of a Device
                // but before this you need to Do Dynamic Color value to false in Theme.kt

                val systemController = rememberSystemUiController()
                val isSystemInDarkMode = isSystemInDarkTheme()

                SideEffect {
                    systemController.setStatusBarColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                NavGraph()

            }
        }
    }
}

