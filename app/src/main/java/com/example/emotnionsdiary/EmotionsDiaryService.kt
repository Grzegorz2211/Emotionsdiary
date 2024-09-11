package com.example.emotnionsdiary

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class EmotionsDiaryService {
    private val retrofit: Retrofit

    //private val apiService: ApiService

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://api.yourbackend.com/") // Replace with your backend URL
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //apiService = retrofit.create(ApiService::class.java)
    }

    fun saveEmotion(emotion: String): String? {
        /*
        val call = apiService.getUserById(id)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null // Handle error or throw an exception
        }
        */
        return "null";
    }
    fun saveEmotionsEditText (emotion: String): String? {
        /*
        val call = apiService.getUserById(id)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null // Handle error or throw an exception
        }
        */
        return "null";
    }

}