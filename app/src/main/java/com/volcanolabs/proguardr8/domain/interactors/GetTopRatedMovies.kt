package com.volcanolabs.proguardr8.domain.interactors

import com.volcanolabs.proguardr8.data.repositories.MoviesRepository
import com.volcanolabs.proguardr8.domain.entities.MoviesWrapper
import javax.inject.Inject

class GetTopRatedMovies @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute() : MoviesWrapper {
        return moviesRepository.getTopRatedMovies()
    }
}