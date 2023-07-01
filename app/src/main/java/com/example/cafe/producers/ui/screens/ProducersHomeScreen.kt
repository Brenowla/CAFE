package com.example.cafe.producers.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.ui.widget.ProductTypeWidget

@Composable
fun ProducersHomeScreen() {
    val selectedProductsTypeEnum = remember {
        mutableStateOf<ProductsTypeEnum?>(null)
    }
    Column() {
        LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
            item {
                Spacer(modifier = Modifier.height(height = spacing.spacing4))
                CafeEditTextField(
                    modifier = Modifier.padding(horizontal = spacing.spacing4),
                    value = "",
                    iconStart = R.drawable.ic_search
                )
                Spacer(modifier = Modifier.height(height = spacing.spacing4))
                Row(modifier = Modifier.horizontalScroll(state = rememberScrollState())) {
                    Spacer(modifier = Modifier.width(width = spacing.spacing4))
                    ProductsTypeEnum.getAll().forEach { product ->
                        ProductTypeWidget(
                            product = product,
                            selected = selectedProductsTypeEnum.value == product
                        ) {
                            selectedProductsTypeEnum.value =
                                if (product == selectedProductsTypeEnum.value) null else product
                        }
                        Spacer(modifier = Modifier.width(width = spacing.spacing4))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProducersHomeScreen() {
    ProducersHomeScreen()
}