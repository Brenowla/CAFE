package com.example.cafe.common.firebase.providers

import com.example.cafe.common.firebase.FirebaseBase
import com.example.cafe.common.firebase.models.UserModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseSaveUser @Inject constructor() : FirebaseBase<UserModel, FirebaseSaveUser.Params> {

    data class Params(
        val user: UserModel
    )

    override suspend fun produce(
        params: Params,
        onSuccess: (UserModel) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val db = Firebase.firestore
        db.collection("users").add(params.user)
            .addOnSuccessListener {
                onSuccess(params.user)
            }.addOnCompleteListener {
                onCompletion()
            }.addOnFailureListener { exc ->
                onError(exc)
            }
    }


}