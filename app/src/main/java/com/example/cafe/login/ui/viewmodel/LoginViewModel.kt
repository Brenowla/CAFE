package com.example.cafe.login.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.providers.FirebaseAuthenticator
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val mFirebaseAuthenticator: FirebaseAuthenticator
) : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")

    private val mUser = mutableStateOf<FirebaseUser?>(null)
    val user: State<FirebaseUser?>
        get() = mUser

    val error = mutableStateOf<Exception?>(null)
    val loading = mutableStateOf(false)

    fun login() {
        loading.value = true
        viewModelScope.launch {
            mFirebaseAuthenticator.produce(
                FirebaseAuthenticator.Params(
                    email.value,
                    password.value
                ),
                onSuccess = { auth ->
                    mUser.value = auth.user
                },
                onError = { err ->
                    error.value = err
                    error.value = null
                },
                onCompletion = {
                    loading.value = false
                }
            )
        }
    }
}