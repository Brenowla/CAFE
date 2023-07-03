package com.example.cafe.login.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.models.UserModel
import com.example.cafe.common.firebase.providers.FirebaseSaveUser
import com.example.cafe.common.firebase.providers.FirebaseSignUp
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val firebaseSignUp: FirebaseSignUp,
    private val mFirebaseSaveUser: FirebaseSaveUser
) : ViewModel() {

    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val phone = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")

    val loading = mutableStateOf(false)
    val error = mutableStateOf<Exception?>(null)

    val signUp = mutableStateOf(false)

    fun signUp() {
        loading.value = true
        viewModelScope.launch {
            firebaseSignUp.produce(
                params = FirebaseSignUp.Params(email.value, password.value),
                onCompletion = {
                    loading.value = false
                },
                onSuccess = {
                    saveInfo(it)
                }, onError = { exc ->
                    error.value = exc
                }
            )
        }
    }

    private fun saveInfo(user: FirebaseUser) {
        loading.value = true
        viewModelScope.launch {
            mFirebaseSaveUser.produce(
                FirebaseSaveUser.Params(
                    UserModel(
                        id = user.uid,
                        email = email.value,
                        name = name.value,
                        rule = 0,
                        video = null,
                        description = null
                    )
                ), onSuccess = {
                    signUp.value = true
                }, onCompletion = {
                    loading.value = false
                }, onError = {
                    error.value = it
                }
            )
        }
    }
}