package com.volcanolabs.proguardr8.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey private val id: Number,
    private var posterPath: String?,
    private var adult: Boolean?,
    private var overview: String?,
    private var releaseDate: String?,
    private var genreIds: List<Number>?,
    private var originalTitle: String?,
    private var originalLanguage: String?,
    private var title: String?,
    private var backdropPath: String?,
    private var popularity: Number?,
    private var voteCount: Number?,
    private var video: Boolean,
    private var voteAverage: Number
)
