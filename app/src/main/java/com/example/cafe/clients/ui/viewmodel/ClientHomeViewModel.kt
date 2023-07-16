package com.example.cafe.clients.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.providers.FirebaseGetProducts
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientHomeViewModel @Inject constructor(
    private val mGetProducts: FirebaseGetProducts
): ViewModel(){

    private val mAllItems = mutableStateOf<List<ProductModel>>(emptyList())
    val items = mutableStateOf<List<ProductModel>>(emptyList())

    val search = mutableStateOf("")
    val type = mutableStateOf<ProductsTypeEnum?>(null)

    fun getProducts() {
        viewModelScope.launch {
            mGetProducts.produce(Unit, {
                mAllItems.value = it
                items.value = it
            }, {}, {})
        }
    }

    fun filter() {
        val selectedType = type.value
        items.value = mAllItems.value.filter {
            it.name.lowercase()
                .contains(search.value.lowercase()) && (selectedType == null || it.type == selectedType.apiName)
        }
    }
}