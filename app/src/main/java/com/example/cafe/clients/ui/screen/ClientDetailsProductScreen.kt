package com.example.cafe.clients.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cafe.R
import com.example.cafe.clients.ui.viewmodel.ClientProductDetailViewModel
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeButton
import com.example.cafe.common.utils.extensions.format
import com.example.cafe.products.constants.ProductsTypeEnum

@Composable
fun ClientDetailsProductScreen(
    viewModel: ClientProductDetailViewModel,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 400.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.End) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(fraction = 0.5f)
                            .fillMaxHeight()
                            .background(
                                color = colors.primary100,
                                shape = RoundedCornerShape(bottomStart = 48.dp)
                            )
                    )
                }
                AsyncImage(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(size = 12.dp))
                        .size(250.dp),
                    model = viewModel.selectedProduct.value?.image,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(height = spacing.spacing6))
            Column(modifier = Modifier.padding(horizontal = spacing.spacing4)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = viewModel.selectedProduct.value?.name ?: "",
                        style = typography.heading6
                    )
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    Icon(
                        modifier = Modifier.size(size = 24.dp),
                        painter = painterResource(
                            id = ProductsTypeEnum.getFromName(viewModel.selectedProduct.value?.type).icon
                        ),
                        contentDescription = null,
                        tint = colors.secondary100
                    )
                }
                Spacer(modifier = Modifier.height(height = spacing.spacing4))
                Text(
                    text = viewModel.selectedProduct.value?.description ?: "",
                    style = typography.body,
                    color = colors.muted
                )
                Spacer(modifier = Modifier.height(height = spacing.spacing6))
                Text(
                    text = "R$ ${viewModel.selectedProduct.value?.value?.format(2)}",
                    style = typography.heading6
                )
                Spacer(modifier = Modifier.height(height = spacing.spacing5))
                Row {
                    Spacer(modifier = Modifier.weight(weight = 1f))
                    CafeButton(
                        text = "Saiba mais sobre o produtor",
                        iconEnd = R.drawable.ic_arrow_forward
                    ) {
                        navController.navigate("client-producers-detail")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClientDetailsProductScreen() {
//    ClientDetailsProductScreen()
}