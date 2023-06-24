package com.example.cafe.common.firebase.providers

import com.example.cafe.common.firebase.FirebaseBase
import com.example.cafe.common.firebase.models.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FirebaseUserVerification : FirebaseBase<UserModel?, FirebaseUserVerification.Params> {

    data class Params(
        val uid: String
    )

    override suspend fun produce(
        params: Params,
        onSuccess: (UserModel?) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val db = Firebase.firestore
        db.collection("users").whereEqualTo("id", params.uid).get()
            .addOnSuccessListener { document ->
                var user: UserModel? = null
                document.documents.forEachIndexed { index, documentSnapshot ->
                    if (index == 0) {
                        user = documentSnapshot.toObject(UserModel::class.java)
                    }
                }
                onSuccess(user)
            }.addOnCompleteListener {
                onCompletion()
            }.addOnFailureListener { err ->
                onError(err)
            }
    }
}