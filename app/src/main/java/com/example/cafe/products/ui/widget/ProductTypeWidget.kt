package com.example.cafe.products.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.theme.constants.Gray300
import com.example.cafe.products.constants.ProductsTypeEnum

@Composable
fun ProductTypeWidget(product: ProductsTypeEnum, selected: Boolean, onClickListener: () -> Unit) {
    Column(
        modifier = Modifier
            .background(
                color = if (selected) Gray300 else colors.background,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(all = spacing.spacing2)
            .size(size = 64.dp)
            .clickable {
                onClickListener()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = product.icon),
            contentDescription = null,
            modifier = Modifier.size(size = 24.dp),
            tint = colors.secondary100
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        Text(text = product.title, style = typography.sm, color = colors.dark, maxLines = 1)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProductWidget() {
    ProductTypeWidget(product = ProductsTypeEnum.FOOD, selected = true, onClickListener = {})
}
