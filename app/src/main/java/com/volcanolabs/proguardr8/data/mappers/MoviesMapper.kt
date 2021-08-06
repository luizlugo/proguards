package com.volcanolabs.proguardr8.data.mappers

import com.volcanolabs.proguardr8.data.entities.Movie
import javax.inject.Inject

class MoviesMapper @Inject constructor() {
    fun transform(movie: Movie) : com.volcanolabs.proguardr8.domain.entities.Movie {
        return com.volcanolabs.proguardr8.domain.entities.Movie(
            movie.id,
            movie.posterPath,
            movie.adult,
            movie.overview,
            movie.releaseDate,
            movie.genreIds,
            movie.originalTitle,
            movie.originalLanguage,
            movie.title,
            movie.backdropPath,
            movie.popularity,
            movie.voteCount,
            movie.video,
            movie.voteAverage
        )
    }
}