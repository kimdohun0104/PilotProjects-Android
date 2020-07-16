package dohun.kim.repository

import dohun.kim.api.UserResponse
import dohun.kim.model.UserModel

fun UserResponse.toModel() = UserModel(
    login = login,
    id = id,
    avatarUrl = avatarUrl
)