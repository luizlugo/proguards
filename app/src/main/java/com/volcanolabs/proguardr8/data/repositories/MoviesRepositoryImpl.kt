package com.volcanolabs.proguardr8.data.repositories

import com.volcanolabs.proguardr8.data.MoviesApi
import com.volcanolabs.proguardr8.data.mappers.MoviesMapper
import com.volcanolabs.proguardr8.domain.entities.Movie
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    moviesApi: MoviesApi,
    moviesMapper: MoviesMapper
) : MoviesRepository {
    override fun getPopularMovies(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(): List<Movie> {
        TODO("Not yet implemented")
    }
}