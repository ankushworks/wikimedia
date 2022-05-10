package com.ankushsoni.wikimedia.api

import com.androiddevs.mvvmnewsapp.api.WikiApi
import com.ankushsoni.wikimedia.util.Constants.Companion.BASE_URL_2
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {


    companion object{


        var gson = GsonBuilder()
            .setLenient()
            .create()

        private val retrofit by lazy {
            var logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            var client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL_2)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }

        val api by lazy {
            retrofit.create(WikiApi::class.java)
        }
    }
}