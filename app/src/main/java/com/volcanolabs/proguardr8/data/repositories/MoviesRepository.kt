package com.volcanolabs.proguardr8.data.repositories

import com.volcanolabs.proguardr8.domain.entities.Movie

interface MoviesRepository {
    fun getPopularMovies() : List<Movie>
    fun getTopRatedMovies(): List<Movie>
}