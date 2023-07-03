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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    val mFirebaseUserVerification: FirebaseUserVerification
) : ViewModel() {

    val loading = mutableStateOf(true)

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

    fun verifyUserLogged() {
        loading.value = true
        val actualUser = Firebase.auth.currentUser
        if(actualUser != null) {
            getUser(actualUser)
        } else {
            loading.value = false
        }
    }

    fun logout() {
        Firebase.auth.signOut()
        mUser.value = null
    }
}