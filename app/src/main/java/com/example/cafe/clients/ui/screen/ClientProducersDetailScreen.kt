package com.example.cafe.clients.ui.screen

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cafe.clients.ui.viewmodel.ClientProductDetailViewModel
import com.example.cafe.common.theme.CafeTheme
import com.example.cafe.common.ui.components.YoutubePlayer
import com.example.cafe.common.ui.utils.annotatedString

@Composable
fun ClientProducersDetailScreen(
    viewModel: ClientProductDetailViewModel
) {
    LaunchedEffect(true) {
        viewModel.getUser()
    }
    val context = LocalContext.current
    Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
        YoutubePlayer(
            videoId = viewModel.producers.value?.video ?: "",
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
                .background(
                    color = CafeTheme.colors.primary100, shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = CafeTheme.spacing.spacing8,
                        bottomStart = CafeTheme.spacing.spacing8
                    )
                )
        )
        Spacer(modifier = Modifier.height(height = CafeTheme.spacing.spacing4))
        Text(
            text = annotatedString(text = viewModel.producers.value?.description ?: ""),
            style = CafeTheme.typography.body,
            modifier = Modifier.padding(horizontal = CafeTheme.spacing.spacing4)
        )
    }
}