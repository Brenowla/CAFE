package com.example.cafe.clients.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cafe.R
import com.example.cafe.clients.ui.viewmodel.ClientHomeViewModel
import com.example.cafe.clients.ui.viewmodel.ClientProductDetailViewModel
import com.example.cafe.common.theme.CafeTheme
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.ui.widget.ProductTypeWidget
import com.example.cafe.products.ui.widget.ProductWidget

@Composable
fun ClientHomeScreen(
    viewModel: ClientHomeViewModel = hiltViewModel(),
    navController: NavController,
    productDetailViewModel: ClientProductDetailViewModel
) {
    LaunchedEffect(true) {
        viewModel.getProducts()
    }

    LaunchedEffect(viewModel.search.value, viewModel.type.value) {
        viewModel.filter()
    }

    Column() {
        Spacer(modifier = Modifier.height(height = CafeTheme.spacing.spacing4))
        Text(
            text = "Seus produtos",
            modifier = Modifier.padding(horizontal = CafeTheme.spacing.spacing4),
            style = CafeTheme.typography.heading4
        )
        Spacer(modifier = Modifier.height(height = CafeTheme.spacing.spacing4))
        CafeEditTextField(
            modifier = Modifier.padding(horizontal = CafeTheme.spacing.spacing4),
            value = viewModel.search.value,
            onValueChange = { viewModel.search.value = it },
            iconStart = R.drawable.ic_search,
            iconEnd = if (viewModel.search.value.isNotBlank()) R.drawable.ic_clear else null,
            onEndIconClick = { viewModel.search.value = "" }
        )
        Spacer(modifier = Modifier.height(height = CafeTheme.spacing.spacing4))
        Row(modifier = Modifier.horizontalScroll(state = rememberScrollState())) {
            Spacer(modifier = Modifier.width(width = CafeTheme.spacing.spacing4))
            ProductsTypeEnum.getAll().forEach { product ->
                ProductTypeWidget(
                    product = product,
                    selected = viewModel.type.value == product
                ) {
                    viewModel.type.value =
                        if (product == viewModel.type.value) null else product
                }
                Spacer(modifier = Modifier.width(width = CafeTheme.spacing.spacing4))
            }
        }
        LazyVerticalGrid(
            modifier = Modifier.padding(all = CafeTheme.spacing.spacing2),
            columns = GridCells.Fixed(count = 2)
        ) {
            items(items = viewModel.items.value) {
                Row(modifier = Modifier.padding(all = CafeTheme.spacing.spacing2)) {
                    ProductWidget(
                        Modifier
                            .weight(weight = 1f)
                            .clickable {
                                productDetailViewModel.selectProduct(it)
                                navController.navigate("client-product-detail")
                            }, product = it)
                }
            }
        }
    }
}