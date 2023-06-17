package com.example.cafe.common.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.theme.constants.CafeColors
import com.example.cafe.common.theme.constants.CafeSpacing
import com.example.cafe.common.theme.constants.CafeTypography
import com.example.cafe.common.theme.constants.LocalColors
import com.example.cafe.common.theme.constants.LocalSpacing
import com.example.cafe.common.theme.constants.LocalTypography
import com.example.cafe.common.theme.constants.cafeLightColors

object CafeTheme {
    val colors: CafeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: CafeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val spacing: CafeSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current
}

private val LightColorScheme = cafeLightColors()

@Composable
fun CAFETheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary100.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        LocalColors provides colorScheme,
        LocalTypography provides typography,
        LocalSpacing provides spacing,
    ) {
        ProvideTextStyle(
            value = typography.body.copy(color = colorScheme.dark),
            content = content
        )
    }
}