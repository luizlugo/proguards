package com.volcanolabs.proguardr8.domain.entities

data class MoviesWrapper(
    var page: Number,
    var movies: List<Movie>,
    var totalPages: Number,
    var totalResults: Number
)
