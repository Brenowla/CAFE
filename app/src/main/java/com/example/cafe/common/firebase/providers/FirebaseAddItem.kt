package com.example.cafe.common.firebase.providers

import android.net.Uri
import com.example.cafe.common.firebase.FirebaseBase
import com.example.cafe.products.data.model.ProductModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAddItem @Inject constructor() : FirebaseBase<ProductModel, FirebaseAddItem.Params> {

    data class Params(
        val product: ProductModel
    )

    override suspend fun produce(
        params: Params,
        onSuccess: (ProductModel) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val user = Firebase.auth.currentUser
        Firebase.storage.reference.child(params.product.image.split("/").last()).putFile(
            Uri.parse(params.product.image)
        ).await().storage.downloadUrl.addOnSuccessListener { url ->
            Firebase.firestore.collection("products").add(
                params.product.copy(
                    image = url.toString(),
                    producerId = user?.uid ?: ""
                )
            ).addOnSuccessListener {
                onSuccess(
                    params.product.copy(
                        image = url.toString(),
                        producerId = user?.uid ?: ""
                    )
                )
            }.addOnCompleteListener {
                onCompletion()
            }.addOnFailureListener { err ->
                onError(err)
            }
        }.addOnFailureListener { err ->
            onError(err)
        }
    }
}