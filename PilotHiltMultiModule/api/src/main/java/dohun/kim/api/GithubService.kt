package dohun.kim.api

import retrofit2.http.GET

interface GithubService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}