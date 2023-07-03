package com.example.cafe.common.firebase.models

data class UserModel constructor(
    val id: String,
    val email: String,
    val name: String,
    val rule: Int,
    val description: String?,
    val video: String?
) {

    constructor(): this("", "","", -1, "", "")
}