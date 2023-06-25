package com.example.cafe.common.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeButtonStyles.PRIMARY

enum class CafeButtonStyles {
    PRIMARY, SECONDARY;

    val backgroundColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> colors.secondary200
            SECONDARY -> colors.background
        }

    val contentColor: Color
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            PRIMARY -> colors.background
            SECONDARY -> colors.secondary200
        }
}

@Composable
fun CafeButton(
    modifier: Modifier = Modifier,
    text: String,
    type: CafeButtonStyles = PRIMARY,
    @DrawableRes iconStart: Int? = null,
    @DrawableRes iconEnd: Int? = null,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier, onClick = onClick, shape = RoundedCornerShape(spacing.spacing16),
        colors = ButtonDefaults.buttonColors(
            containerColor = type.backgroundColor,
            contentColor = type.contentColor,
            disabledContainerColor = type.backgroundColor.copy(alpha = 0.5f),
            disabledContentColor = type.contentColor.copy(alpha = 0.5f)
        )
    ) {
        iconStart?.let { icon ->
            Icon(
                modifier = Modifier.size(size = 12.dp),
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(width = spacing.spacing2))
        }
        Text(text = text, style = typography.body)
        iconEnd?.let { icon ->
            Spacer(modifier = Modifier.width(width = spacing.spacing2))
            Icon(
                modifier = Modifier.size(size = 12.dp),
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCafeButton() {
    CafeButton(text = "Texto do botão") {}
}