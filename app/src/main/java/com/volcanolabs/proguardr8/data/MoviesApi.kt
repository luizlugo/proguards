package com.volcanolabs.proguardr8.data

import com.volcanolabs.proguardr8.data.entities.Movie
import com.volcanolabs.proguardr8.data.entities.MoviesWrapperResponse
import retrofit2.http.GET

interface MoviesApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesWrapperResponse
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): MoviesWrapperResponse
}