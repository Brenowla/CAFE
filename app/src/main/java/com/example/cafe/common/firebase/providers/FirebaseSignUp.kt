package com.example.cafe.common.firebase.providers

import com.example.cafe.common.firebase.FirebaseBase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseSignUp @Inject constructor(): FirebaseBase<FirebaseUser,FirebaseSignUp.Params> {

    data class Params(
        val email: String,
        val password: String
    )

    override suspend fun produce(
        params: Params,
        onSuccess: (FirebaseUser) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val firebaseAuth = Firebase.auth
        firebaseAuth.createUserWithEmailAndPassword(params.email, params.password)
            .addOnSuccessListener {
                val user = firebaseAuth.currentUser
                onSuccess(user!!)
            }.addOnCompleteListener {
                onCompletion()
            }.addOnFailureListener { exc ->
                onError(exc)
            }
    }
}