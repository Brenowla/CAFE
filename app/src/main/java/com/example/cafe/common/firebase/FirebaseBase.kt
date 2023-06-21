package com.example.cafe.common.firebase

interface FirebaseBase<T,V> {

    suspend fun produce(
        params: V,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit,
        onCompletion: () -> Unit
    )
}