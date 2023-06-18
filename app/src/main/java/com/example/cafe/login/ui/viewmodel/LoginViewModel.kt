package com.example.cafe.login.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.FirebaseAuthenticator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun login() {
        viewModelScope.launch {
            FirebaseAuthenticator.authenticate(
                email.value,
                password.value,
                onSuccess = {
                    val a = "deu bom"
                },
                onFailure = {
                    val b = "deu ruim"
                }
            )
        }
    }
}