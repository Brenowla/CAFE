package com.example.cafe.common.theme.constants

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class CafeTypography(
    val heading1: TextStyle = TextStyle(
        fontSize = 40.sp,
        lineHeight = 48.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val heading2: TextStyle = TextStyle(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val heading3: TextStyle = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val heading4: TextStyle = TextStyle(
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val heading5: TextStyle = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val heading6: TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val subHeading: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val bodyBold: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val body: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Medium
    ),
    val smBold: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Bold
    ),
    val sm: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Medium
    ),
    val note: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 4.sp,
        fontFamily = montserratFamily,
        fontWeight = FontWeight.Medium
    )
)

internal val LocalTypography = staticCompositionLocalOf { CafeTypography() }