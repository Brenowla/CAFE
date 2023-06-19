package com.example.cafe.common.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafe.common.theme.CAFETheme
import com.example.cafe.common.theme.CafeTheme
import com.example.cafe.common.ui.LoadingScreen
import com.example.cafe.common.ui.viewmodels.ActivityViewModel
import com.example.cafe.login.ui.screen.LoginScreen
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
                Surface(color = CafeTheme.colors.light100) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        NavHost(navController = navController, startDestination = "login") {
                            composable(route = "login") {
                                LoginScreen()
                            }
                        }
                        if(mActivityViewModel.loading.value) {
                            LoadingScreen()
                        }
                    }

                }
            }
        }
    }
}
