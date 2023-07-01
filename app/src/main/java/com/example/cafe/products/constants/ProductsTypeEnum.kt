package com.example.cafe.products.constants

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.example.cafe.R

enum class ProductsTypeEnum{
    FOOD, CLOTHES, CRAFTSMANSHIP, OTHERS;

    val icon: Int
    @Composable
    @ReadOnlyComposable
    @DrawableRes get() = when(this) {
        FOOD -> R.drawable.ic_food
        CLOTHES -> R.drawable.ic_clothes
        CRAFTSMANSHIP -> R.drawable.ic_craftsmanship
        OTHERS -> R.drawable.bag
    }

    val title: String
    @Composable
    @ReadOnlyComposable
    get() = when(this) {
        FOOD -> "Comida"
        CLOTHES -> "Roupas"
        CRAFTSMANSHIP -> "Artesanato"
        OTHERS -> "Outros"
    }

    companion object {
        fun getAll() = values().toList()
    }
}