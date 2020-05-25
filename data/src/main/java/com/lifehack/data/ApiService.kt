package com.lifehack.data

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.lifehack.data.model.Company
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("test_task/test.php")
    suspend fun getCompanies(): List<Company>

    companion object ApiFactory {

        const val BASE_URL = "http://megakohz.bget.ru/"
        lateinit var INSTANCE: ApiService

        fun create(): ApiService {
            synchronized(this) {
                if (!::INSTANCE.isInitialized)
                    INSTANCE = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .client(buildClient())
                        .build()
                        .create(ApiService::class.java)
                return INSTANCE
            }
        }

        private fun buildClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()
    }
}