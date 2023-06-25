package com.example.cafe.common.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafe.common.firebase.models.UserModel
import com.example.cafe.common.firebase.providers.FirebaseAuthenticator
import com.example.cafe.common.firebase.providers.FirebaseUserVerification
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    val mFirebaseUserVerification: FirebaseUserVerification
) : ViewModel() {

    val loading = mutableStateOf(false)

    private val mUser = mutableStateOf<UserModel?>(null)
    val user: State<UserModel?>
        get() = mUser


    fun getUser(user: FirebaseUser) {
        loading.value = true
        viewModelScope.launch {
            mFirebaseUserVerification.produce(
                params = FirebaseUserVerification.Params(
                    user.uid
                ),
                onSuccess = { user ->
                    mUser.value = user
                },
                onCompletion = {
                    loading.value = false
                },
                onError = { exc ->
                    Log.d("", "Deu ruim")
                }
            )
        }
    }
}