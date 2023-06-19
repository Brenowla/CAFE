package com.example.cafe.common.firebase

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import java.lang.Exception

object FirebaseAuthenticator {

    suspend fun authenticate(
        email: String,
        password: String,
        onSuccess: (AuthResult) -> Unit,
        onFailure: (Exception) -> Unit,
        onCompletion: () -> Unit
    ) {
        val authenticator = FirebaseAuth.getInstance()
        authenticator.signInWithEmailAndPassword(
            email, password
        ).addOnSuccessListener {
            onSuccess(it)
        }.addOnCompleteListener {
            onCompletion()
        }.addOnFailureListener { exc ->
            onFailure(exc)
        }
    }
}