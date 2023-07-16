package com.example.cafe.clients.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cafe.clients.ui.viewmodel.ClientProductDetailViewModel

@Composable
fun ClientBaseNavigation(
    snackbarHostState: SnackbarHostState,
    viewModel: ClientProductDetailViewModel = hiltViewModel(),
    onLogoutClick: () -> Unit
) {
    val navController = rememberNavController()
    Column {
        Column(modifier = Modifier.weight(weight = 1f)) {
            NavHost(startDestination = "client-home", navController = navController) {
                composable("client-home") {
                    ClientHomeScreen(productDetailViewModel = viewModel, navController = navController)
                }
                composable("client-product-detail") {
                    ClientDetailsProductScreen(viewModel = viewModel, navController = navController)
                }
                composable("client-producers-detail") {
                    ClientProducersDetailScreen(viewModel = viewModel)
                }
            }
        }
        ClientBottomNavigation(navController = navController) {
            onLogoutClick()
        }
    }
}