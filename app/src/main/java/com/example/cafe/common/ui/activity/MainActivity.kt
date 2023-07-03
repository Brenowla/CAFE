package com.example.cafe.common.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
import com.example.cafe.producers.ui.screens.ProducersBaseNavigation
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
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            CAFETheme() {
                LaunchedEffect(true) {
                    mActivityViewModel.verifyUserLogged()
                }

                LaunchedEffect(mActivityViewModel.user.value) {
                    mActivityViewModel.user.value?.let {
                        if (it.rule == 1) {
                            navController.navigate("producers") {
                                popUpTo("login") {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
                Scaffold(
                    containerColor = colors.light100,
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
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
                                SignUpScreen(navController = navController) {
                                    navController.navigate("login") {
                                        popUpTo("login") {
                                            inclusive = true
                                        }
                                    }
                                }
                            }
                            composable(route = "producers") {
                                ProducersBaseNavigation(snackbarHostState = snackbarHostState) {
                                    mActivityViewModel.logout()
                                    navController.navigate("login") {
                                        popUpTo("producers") {
                                            inclusive = true
                                        }
                                    }
                                }
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
