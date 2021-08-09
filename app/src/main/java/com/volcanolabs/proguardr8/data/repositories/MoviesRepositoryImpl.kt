package com.volcanolabs.proguardr8.data.repositories

import com.volcanolabs.proguardr8.data.MoviesApi
import com.volcanolabs.proguardr8.data.mappers.MoviesMapper
import com.volcanolabs.proguardr8.domain.entities.MoviesWrapper
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val moviesMapper: MoviesMapper
) : MoviesRepository {
    override suspend fun getPopularMovies(): MoviesWrapper =
        moviesApi.getPopularMovies().let {
            moviesMapper.transform(it)
        }

    override suspend fun getTopRatedMovies(): MoviesWrapper =
        moviesApi.getTopRatedMovies().let {
            moviesMapper.transform(it)
        }
}