package dohun.kim.pilotpaging3.data

import dohun.kim.pilotpaging3.BuildConfig
import dohun.kim.pilotpaging3.model.GifModelWrapper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("v1/gifs/trending")
    suspend fun getGifs(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): GifModelWrapper

    companion object {
        private var INSTANCE: GiphyService? = null

        fun getInstance(): GiphyService {
            return INSTANCE ?: Retrofit.Builder()
                .baseUrl("https://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor { chain ->
                    val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("api_key", BuildConfig.GIPHY_API_KEY)
                        .build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                }.build())
                .build()
                .create(GiphyService::class.java)
                .also { INSTANCE = it }
        }
    }
}