package dohun.kim.pilotdynamiclink.data

import dohun.kim.pilotdynamiclink.model.UserModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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
    fun getUsers(): Call<List<UserModel>>
}