package com.example.cafe.producers.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.providers.FirebaseGetProductsFromProducer
import com.example.cafe.products.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProducersHomeViewModel @Inject constructor(
    private val firebaseGetProductsFromProducer: FirebaseGetProductsFromProducer
): ViewModel() {

    val items = mutableStateOf<List<ProductModel>>(emptyList())

    fun getProducts() {
        viewModelScope.launch {
            firebaseGetProductsFromProducer.produce(Unit, {
                items.value = it
            }, {}, {})
        }
    }
}