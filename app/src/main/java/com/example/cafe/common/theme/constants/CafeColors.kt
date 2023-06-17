package com.example.cafe.common.theme.constants

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

class CafeColors(
    primary100: Color,
    primary200: Color,
    secondary100: Color,
    secondary200: Color,
    info: Color,
    dark: Color,
    muted: Color,
    background: Color,
    light100: Color
) {

    var primary100 by mutableStateOf(primary100, structuralEqualityPolicy())
        internal set

    var primary200 by mutableStateOf(primary200, structuralEqualityPolicy())
        internal set

    var secondary100 by mutableStateOf(secondary100, structuralEqualityPolicy())
        internal set

    var secondary200 by mutableStateOf(secondary200, structuralEqualityPolicy())
        internal set

    var info by mutableStateOf(info, structuralEqualityPolicy())
        internal set

    var dark by mutableStateOf(dark, structuralEqualityPolicy())
        internal set

    var muted by mutableStateOf(muted, structuralEqualityPolicy())
        internal set

    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set

    var light100 by mutableStateOf(light100, structuralEqualityPolicy())
        internal set
}

fun cafeLightColors(
    primary100: Color = Primary100,
    primary200: Color = Primary200,
    secondary100: Color = Secondary100,
    secondary200: Color = Secondary200,
    info: Color = Info,
    dark: Color = Gray900,
    muted: Color = Gray600,
    background: Color = NeutralWhite,
    light100: Color = Gray200
) = CafeColors(
    primary100 = primary100,
    primary200 = primary200,
    secondary100 = secondary100,
    secondary200 = secondary200,
    info = info,
    dark = dark,
    muted = muted,
    background = background,
    light100 = light100
)

internal val LocalColors = staticCompositionLocalOf { cafeLightColors() }