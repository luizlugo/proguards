package com.volcanolabs.proguardr8.di

import com.volcanolabs.proguardr8.BuildConfig
import com.volcanolabs.proguardr8.data.MoviesApi
import com.volcanolabs.proguardr8.di.interceptors.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val apiBaseUrl = "https://api.themoviedb.org/3"

    @Provides
    @Singleton
    fun provideOkHttpClient(apiKeyInterceptor: ApiKeyInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor { message: String? ->
                Timber.tag("OkHttpClient").i(message)
            }
            loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
            httpClient.addInterceptor(loggingInterceptor)
        }

        httpClient.addInterceptor(apiKeyInterceptor)

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideMoviesService(okHttpClient: OkHttpClient): MoviesApi {
        return Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }
}