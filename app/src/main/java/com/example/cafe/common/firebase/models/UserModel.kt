package com.example.cafe.common.firebase.models

data class UserModel constructor(
    val id: String,
    val email: String,
    val name: String,
    val rule: Int
) {

    constructor(): this("", "","", -1)
}