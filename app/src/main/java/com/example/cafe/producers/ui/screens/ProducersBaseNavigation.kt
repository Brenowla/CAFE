package com.example.cafe.producers.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ProducersBaseNavigation(snackbarHostState: SnackbarHostState, onLogoutClick: () -> Unit) {
    val navController = rememberNavController()
    Column {
        Column(modifier = Modifier.weight(weight = 1f)) {
            NavHost(startDestination = "producers-home", navController = navController) {
                composable("producers-home") {
                    ProducersHomeScreen()
                }
                composable("producers-add-item") {
                    ProducersAddItemScreen(snackbarHostState = snackbarHostState)
                }
                composable("producers-description-screen") {
                    ProducersDescriptionScreen()
                }
            }
        }
        ProducersBottomNavigation(navController = navController) {
            onLogoutClick()
        }
    }
}