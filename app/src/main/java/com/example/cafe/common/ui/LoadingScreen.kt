package com.example.cafe.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme.colors

@Composable
fun LoadingScreen() {
    val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.dot_loading))
    Column(modifier = Modifier.fillMaxWidth().background(color = colors.light100), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(weight = 1f))
        LottieAnimation(composition = composition.value, iterations = LottieConstants.IterateForever)
        Spacer(modifier = Modifier.weight(weight = 1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingScreen() {
    LoadingScreen()
}