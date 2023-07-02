package com.example.cafe.products.data.model

data class ProductModel(
    val name: String,
    val image: String,
    val value: Double,
    val description: String,
    val type: String,
    val producerId: String
) {

    constructor(): this("", "", 0.0, "", "", "")
}
