package com.volcanolabs.proguardr8.domain.entities

data class Movie(
    val id: Number,
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    val releaseDate: String?,
    val genreIds: List<Number>?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val title: String?,
    val backdropPath: String?,
    val popularity: Number?,
    val voteCount: Number?,
    val video: Boolean,
    val voteAverage: Number
)