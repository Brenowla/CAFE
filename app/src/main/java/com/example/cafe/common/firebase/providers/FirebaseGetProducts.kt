package com.example.cafe.common.firebase.providers

import com.example.cafe.common.firebase.FirebaseBase
import com.example.cafe.products.data.model.ProductModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseGetProducts @Inject constructor() :
    FirebaseBase<List<ProductModel>, Unit> {

    override suspend fun produce(
        params: Unit,
        onSuccess: (List<ProductModel>) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val db = Firebase.firestore
        db.collection("products").get()
            .addOnSuccessListener { document ->
                document.documents.map {
                    it.toObject(ProductModel::class.java)
                }.let { onSuccess(it as List<ProductModel>) }
            }.addOnCompleteListener {
                onCompletion()
            }.addOnFailureListener { err ->
                onError(err)
            }
    }
}