package com.example.cafe.common.utils.extensions

fun Double.format(digits: Int) = "%.${digits}f".format(this)