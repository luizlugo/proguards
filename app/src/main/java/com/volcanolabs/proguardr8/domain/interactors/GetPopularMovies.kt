package com.volcanolabs.proguardr8.domain.interactors

import com.volcanolabs.proguardr8.data.repositories.MoviesRepositoryImpl
import javax.inject.Inject

class GetPopularMovies @Inject constructor(
    moviesRepositoryImpl: MoviesRepositoryImpl
) {
}