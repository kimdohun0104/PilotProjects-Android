package dohun.kim.pilotdynamiclink.data

import dohun.kim.pilotdynamiclink.model.RepositoryModel
import dohun.kim.pilotdynamiclink.model.UserModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    companion object {
        private var githubService: GithubService? = null

        fun getService(): GithubService {
            return githubService ?: Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
                .also {
                    githubService = it
                }
        }
    }

    @GET("users")
    suspend fun getUsers(): List<UserModel>

    @GET("users/{username}/repos")
    suspend fun getRepositories(@Path("username") login: String): List<RepositoryModel>
}