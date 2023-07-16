package com.example.cafe.clients.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.models.UserModel
import com.example.cafe.common.firebase.providers.FirebaseUserVerification
import com.example.cafe.products.data.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val mFirebaseUserVerification: FirebaseUserVerification
) : ViewModel() {

    private val mSelectedProduct = mutableStateOf<ProductModel?>(null)
    val selectedProduct: State<ProductModel?>
        get() = mSelectedProduct

    private val mProducers = mutableStateOf<UserModel?>(null)
    val producers: State<UserModel?>
        get() = mProducers

    fun selectProduct(product: ProductModel) {
        mSelectedProduct.value = product
    }

    fun getUser() {
        viewModelScope.launch {

            mFirebaseUserVerification.produce(
                params = FirebaseUserVerification.Params(
                    mSelectedProduct.value?.producerId ?: return@launch
                ),
                onSuccess = {
                    mProducers.value = it
                },
                onCompletion = {},
                onError = {}
            )
        }
    }
}