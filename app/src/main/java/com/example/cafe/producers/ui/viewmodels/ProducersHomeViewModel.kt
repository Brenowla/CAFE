package com.example.cafe.producers.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.providers.FirebaseGetProductsFromProducer
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProducersHomeViewModel @Inject constructor(
    private val firebaseGetProductsFromProducer: FirebaseGetProductsFromProducer
) : ViewModel() {

    private val mAllItems = mutableStateOf<List<ProductModel>>(emptyList())
    val items = mutableStateOf<List<ProductModel>>(emptyList())

    val search = mutableStateOf("")
    val type = mutableStateOf<ProductsTypeEnum?>(null)

    fun getProducts() {
        viewModelScope.launch {
            firebaseGetProductsFromProducer.produce(Unit, {
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