package com.example.cafe.producers.ui.viewmodels

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.providers.FirebaseAddItem
import com.example.cafe.products.constants.ProductsTypeEnum
import com.example.cafe.products.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProducersAddItemViewModel @Inject constructor(
    private val firebaseAddItem: FirebaseAddItem
) : ViewModel() {

    val image = mutableStateOf<Uri?>(null)
    val name = mutableStateOf("")
    val value = mutableStateOf("")
    val description = mutableStateOf("")
    val type = mutableStateOf(ProductsTypeEnum.OTHERS)

    val loading = mutableStateOf(false)

    val success = mutableStateOf(false)
    val error = mutableStateOf(false)

    fun saveItem() {
        loading.value = true
        viewModelScope.launch {
            firebaseAddItem.produce(
                FirebaseAddItem.Params(
                    ProductModel(
                        name.value,
                        image.value.toString(),
                        value.value.toDouble(),
                        description.value,
                        type.value.apiName,
                        ""
                    )
                ), onSuccess = {
                    success.value = true
                }, onCompletion = {
                    loading.value = false
                }, onError = {
                    error.value = true
                }
            )
        }
    }

    fun clearFields() {
        image.value = null
        val name = ""
        val value = ""
        val description = ""
        val type = ProductsTypeEnum.OTHERS
    }
}