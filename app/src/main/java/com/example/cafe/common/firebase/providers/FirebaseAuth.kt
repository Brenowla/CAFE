package com.example.cafe.common.firebase.providers

import com.example.cafe.common.firebase.FirebaseBase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthenticator @Inject constructor(): FirebaseBase<AuthResult, FirebaseAuthenticator.Params> {

    data class Params(
        val email: String,
        val password: String
    )

    override suspend fun produce(
        params: Params,
        onSuccess: (AuthResult) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val authenticator = FirebaseAuth.getInstance()
        authenticator.signInWithEmailAndPassword(
            params.email, params.password
        ).addOnSuccessListener {
            onSuccess(it)
        }.addOnCompleteListener {
            onCompletion()
        }.addOnFailureListener { exc ->
            onError(exc)
        }
    }
}