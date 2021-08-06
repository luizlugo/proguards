package com.volcanolabs.proguardr8.data

import com.volcanolabs.proguardr8.data.entities.Movie
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movie/popular")
    suspend fun getPopularMovies(): List<Movie>
    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(): List<Movie>
}