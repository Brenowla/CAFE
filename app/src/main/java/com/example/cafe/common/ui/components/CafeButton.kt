package com.example.cafe.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography

@Composable
fun CafeButton() {
    Button(
        onClick = {}, shape = RoundedCornerShape(spacing.spacing16),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.secondary200,
            contentColor = colors.background,
            disabledContainerColor = colors.secondary200.copy(alpha = 0.5f),
            disabledContentColor = colors.background.copy(alpha = 0.5f)
        )
    ) {
        Text(text = "Texto do botao", style = typography.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCafeButton() {
    CafeButton()
}