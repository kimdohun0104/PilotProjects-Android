package dohun.kim.pilothilt.data

import dohun.kim.pilothilt.model.UserModel
import retrofit2.http.GET

interface GithubService {

    @GET("users")
    suspend fun getUsers(): List<UserModel>
}