package com.example.mvvm_add_course.models.remote

import com.example.mvvm_add_course.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getRetrofit(): Retrofit{
        // In built interceptor, JOB is to LOG any request/response over retrofit network call.
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        //Build retrofit Client
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    fun getApiHelper(): ApiHelper{
        val retrofit = getRetrofit()

        val apiHelper = ApiHelper(retrofit.create(ApiService::class.java))

        return apiHelper
    }

}