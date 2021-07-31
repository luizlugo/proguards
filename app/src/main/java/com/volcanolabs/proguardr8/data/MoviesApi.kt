package com.volcanolabs.proguardr8.data

import retrofit2.http.GET

interface MoviesApi {
    @GET("/movie/popular")
    suspend fun getPopularMovies() {

    }
}