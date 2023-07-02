package com.example.cafe.products.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.utils.extensions.format
import com.example.cafe.products.data.model.ProductModel

@Composable
fun ProductWidget(product: ProductModel) {
    Column(
        modifier = Modifier
            .background(
                color = colors.background,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(all = 16.dp)
    ) {
        AsyncImage(
            model = product.image,
            contentDescription = null,
            modifier = Modifier.height(height = 126.dp)
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        Text(text = product.name, style = typography.body, color = colors.muted)
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        Text(text = "R$ ${product.value.format(2)}", style = typography.bodyBold, color = colors.muted)
    }
}

@Preview(showBackground = true, widthDp = 126)
@Composable
private fun PreviewProductWidget() {
    ProductWidget(
        product = ProductModel(
            name = "Morangos",
            image = "https://www.proativaalimentos.com.br/image/cache/catalog/img_prod/oleo-essencia-morango-100ml-fruta-puro-essencia-massagem-D_NQ_NP_960102-MLB31202671230_062019-F[1]-1000x1000.jpg",
            value = 10.50,
            description = "jidscjadkabkdc nhdcadjcha jxdhankd dcaucdxkahckd dncak cdka c",
            "",
            producerId = "fsldknad"
        )
    )
}