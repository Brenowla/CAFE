package com.example.cafe.producers.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@Composable
fun ProducersBaseNavigation() {
    val navController = rememberNavController()
    Column {
        Column(modifier = Modifier.weight(weight = 1f)) {
            NavHost(startDestination = "producers-home", navController = navController) {
                composable("producers-home") {
                    ProducersHomeScreen()
                }
            }
        }
        ProducersBottomNavigation(navController = navController)
    }
}