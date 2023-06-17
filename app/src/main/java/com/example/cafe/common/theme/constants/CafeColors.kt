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

    fun copy(
        primary100: Color = this.primary100,
        primary200: Color = this.primary200,
        secondary100: Color = this.secondary100,
        secondary200: Color = this.secondary200,
        info: Color = this.info,
        dark: Color = this.dark,
        muted: Color = this.muted,
        background: Color = this.background
    ): CafeColors = CafeColors(
        primary100,
        primary200,
        secondary100,
        secondary200,
        info,
        dark,
        muted,
        background
    )

    fun updateColorsFrom(other: CafeColors) {
        primary100 = other.primary100
        primary200 = other.primary200
        secondary100 = other.secondary100
        secondary200 = other.secondary200
        info = other.info
        dark = other.dark
        muted = other.muted
        background = other.background
    }
}

fun cafeLightColors(
    primary100: Color = Primary100,
    primary200: Color = Primary200,
    secondary100: Color = Secondary100,
    secondary200: Color = Secondary200,
    info: Color = Info,
    dark: Color = Gray900,
    muted: Color = Gray600,
    background: Color = NeutralWhite
) = CafeColors(
    primary100 = primary100,
    primary200 = primary200,
    secondary100 = secondary100,
    secondary200 = secondary200,
    info = info,
    dark = dark,
    muted = muted,
    background = background
)

internal val LocalColors = staticCompositionLocalOf { cafeLightColors() }