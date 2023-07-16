package com.example.cafe.clients.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme

@Composable
fun ClientBottomNavigation(
    navController: NavController = rememberNavController(),
    onLogoutClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(
                color = CafeTheme.colors.secondary200,
                shape = RoundedCornerShape(
                    topEnd = 16.dp,
                    topStart = 16.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .padding(vertical = CafeTheme.spacing.spacing2)
    ) {
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
            contentDescription = null,
            modifier = Modifier
                .height(height = 32.dp)
                .clickable {
                    navController.navigate("client-home")
                },
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_list),
            contentDescription = null,
            modifier = Modifier
                .height(height = 32.dp)
                .clickable {
//                    navController.navigate("producers-add-item")
                },
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_clear),
            contentDescription = null,
            modifier = Modifier
                .height(height = 32.dp)
                .clickable {
                    onLogoutClick()
                },
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
    }
}