package com.example.cafe.common.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafe.common.theme.CAFETheme
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.ui.LoadingScreen
import com.example.cafe.common.ui.viewmodels.ActivityViewModel
import com.example.cafe.login.ui.screen.LoginScreen
import com.example.cafe.login.ui.screen.SignUpScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mActivityViewModel by viewModels<ActivityViewModel>()
    fun loading(loading: Boolean) {
        mActivityViewModel.loading.value = loading
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CAFETheme() {
                Scaffold(
                    containerColor = colors.light100
                ) { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues = paddingValues)
                    ) {
                        NavHost(navController = navController, startDestination = "login") {
                            composable(route = "login") {
                                LoginScreen(navController = navController) { user ->
                                    mActivityViewModel.getUser(user)
                                }
                            }
                            composable(route = "sign-up") {
                                SignUpScreen(navController = navController)
                            }
                        }
                        if (mActivityViewModel.loading.value) {
                            LoadingScreen()
                        }
                    }
                }
            }
        }
    }
}
