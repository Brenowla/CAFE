package com.example.cafe.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.theme.constants.Gray200

@Composable
fun CafeEditTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit = {},
    maxLines: Int = 1,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(modifier = modifier) {
        BasicTextField(
            value = value, onValueChange = {
                onValueChange(it)
            }, textStyle = typography.sm, keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            maxLines = maxLines,
            visualTransformation = visualTransformation
        ) { innerTextField ->
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = colors.background,
                            shape = RoundedCornerShape(
                                spacing.spacing16
                            )
                        )
                        .border(
                            color = colors.light100,
                            width = Dp.Hairline,
                            shape = RoundedCornerShape(
                                spacing.spacing16
                            )
                        )
                        .padding(horizontal = spacing.spacing3, vertical = spacing.spacing3)
                ) {
                    Box(modifier.weight(weight = 1f)) {
                        if (value.isBlank()) {
                            Text(text = placeholder, style = typography.sm, color = colors.muted)
                        }
                        innerTextField()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCafeEditTextField() {
    CafeEditTextField(
        value = "",
        placeholder = "akdhascdba"
    )
}