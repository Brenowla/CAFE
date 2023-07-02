package com.example.cafe.producers.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.data.model.ProductModel
import com.example.cafe.products.ui.widget.ProductTypeWidget
import com.example.cafe.products.ui.widget.ProductWidget

val product = ProductModel(
    name = "Morangos",
    image = "https://www.proativaalimentos.com.br/image/cache/catalog/img_prod/oleo-essencia-morango-100ml-fruta-puro-essencia-massagem-D_NQ_NP_960102-MLB31202671230_062019-F[1]-1000x1000.jpg",
    value = 10.50,
    description = "jidscjadkabkdc nhdcadjcha jxdhankd dcaucdxkahckd dncak cdka c",
    producerId = "fsldknad"
)

@Composable
fun ProducersHomeScreen() {
    val selectedProductsTypeEnum = remember {
        mutableStateOf<ProductsTypeEnum?>(null)
    }
    val products = remember {
        mutableStateOf(listOf(product, product, product, product, product, product))
    }
    Column() {
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        Text(text = "Seus produtos", modifier = Modifier.padding(horizontal = spacing.spacing4), style = typography.heading4)
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
        LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
            items(items = products.value) {
                Box(modifier = Modifier.padding(all = spacing.spacing4)) {
                    ProductWidget(product = it)
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