package com.example.cafe.common.ui.utils

import android.content.Context
import com.example.cafe.common.ui.activity.MainActivity

fun Context.getActivity(): MainActivity? {
    return try {
        this as MainActivity
    } catch (_: Exception) {
        null
    }
}

fun Context.setLoading(loading: Boolean) {
    this.getActivity()?.loading(loading)
}

fun Context.getUser() = this.getActivity()?.loggedUser()