package com.example.cafe.producers.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafe.common.theme.CafeTheme
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.YoutubePlayer
import com.example.cafe.common.ui.utils.getUser

@Composable
fun ProducersDescriptionScreen() {
    val context = LocalContext.current
    val user = context.getUser()
    Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
        YoutubePlayer(videoId = user?.video ?: "", modifier = Modifier.fillMaxWidth())
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
                .background(
                    color = CafeTheme.colors.primary100, shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = spacing.spacing8,
                        bottomStart = spacing.spacing8
                    )
                )
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        Text(
            text = user?.description ?: "",
            style = typography.body,
            modifier = Modifier.padding(horizontal = spacing.spacing4)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProducersDescriptionScreen() {
    ProducersDescriptionScreen()
}