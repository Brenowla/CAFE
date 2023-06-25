package com.example.cafe.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeButtonStyles.PRIMARY

enum class CafeButtonStyles{
    PRIMARY, SECONDARY;

    val backgroundColor: Color
    @Composable
    @ReadOnlyComposable
    get() = when(this) {
        PRIMARY -> colors.secondary200
        SECONDARY -> colors.background
    }

    val contentColor: Color
    @Composable
    @ReadOnlyComposable
    get() = when(this) {
        PRIMARY -> colors.background
        SECONDARY -> colors.secondary200
    }
}

@Composable
fun CafeButton(
    modifier: Modifier = Modifier,
    text: String,
    type: CafeButtonStyles = PRIMARY ,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,onClick = onClick, shape = RoundedCornerShape(spacing.spacing16),
        colors = ButtonDefaults.buttonColors(
            containerColor = type.backgroundColor,
            contentColor = type.contentColor,
            disabledContainerColor = type.backgroundColor.copy(alpha = 0.5f),
            disabledContentColor = type.contentColor.copy(alpha = 0.5f)
        )
    ) {
        Text(text = text, style = typography.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCafeButton() {
    CafeButton(text = "Texto do botão") {}
}