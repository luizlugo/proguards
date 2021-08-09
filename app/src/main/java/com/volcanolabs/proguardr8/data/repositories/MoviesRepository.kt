package com.volcanolabs.proguardr8.data.repositories

import com.volcanolabs.proguardr8.domain.entities.MoviesWrapper

interface MoviesRepository {
    suspend fun getPopularMovies() : MoviesWrapper
    suspend fun getTopRatedMovies(): MoviesWrapper
}