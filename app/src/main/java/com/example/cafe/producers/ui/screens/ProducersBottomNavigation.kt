package com.example.cafe.producers.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing

@Composable
fun ProducersBottomNavigation(navController: NavController = rememberNavController()) {
    Row(
        modifier = Modifier.background(
            color = colors.secondary200,
            shape = RoundedCornerShape(
                topEnd = 16.dp,
                topStart = 16.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            )
        ).padding(vertical = spacing.spacing2)
    ) {
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
            contentDescription = null,
            modifier = Modifier
                .height(height = 32.dp)
                .clickable {
                    navController.navigate("producers-home")
                },
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_add_circle),
            contentDescription = null,
            modifier = Modifier.height(height = 32.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_info),
            contentDescription = null,
            modifier = Modifier.height(height = 32.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProducersBottomNavigation() {
    ProducersBottomNavigation()
}