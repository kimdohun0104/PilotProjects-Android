package dohun.kim.api

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val login: String,

    val id: Int,

    @SerializedName("avatar_url")
    val avatarUrl: String
)