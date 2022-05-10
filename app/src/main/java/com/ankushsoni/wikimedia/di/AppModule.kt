package com.ankushsoni.wikimedia.di

import android.app.Application
import androidx.room.Room
import com.androiddevs.mvvmnewsapp.api.WikiApi
import com.ankushsoni.wikimedia.db.WikimediaDataBase
import com.ankushsoni.wikimedia.util.Constants.Companion.BASE_URL_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): WikiApi =
        retrofit.create(WikiApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : WikimediaDataBase =
        Room.databaseBuilder(app, WikimediaDataBase::class.java, "wikimedia_database")
            .build()


}