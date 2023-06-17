package com.example.cafe.common.theme.constants

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class CafeSpacing(
    val spacing0: Dp = 0.dp,
    val spacing1: Dp = 4.dp,
    val spacing2: Dp = 8.dp,
    val spacing3: Dp = 12.dp,
    val spacing4: Dp = 16.dp,
    val spacing5: Dp = 20.dp,
    val spacing6: Dp = 24.dp,
    val spacing7: Dp = 32.dp,
    val spacing8: Dp = 40.dp,
    val spacing9: Dp = 48.dp,
    val spacing10: Dp = 56.dp,
    val spacing11: Dp = 64.dp,
    val spacing12: Dp = 72.dp,
    val spacing13: Dp = 80.dp,
    val spacing14: Dp = 96.dp,
    val spacing15: Dp = 112.dp,
    val spacing16: Dp = 128.dp
)

internal val LocalSpacing = staticCompositionLocalOf { CafeSpacing() }