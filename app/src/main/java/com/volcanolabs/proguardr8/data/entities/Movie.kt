package com.volcanolabs.proguardr8.data.entities

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Number,
    @SerializedName("poster_path")
    var posterPath: String?,
    @SerializedName("adult")
    var adult: Boolean?,
    @SerializedName("overview")
    var overview: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Number>?,
    @SerializedName("original_title")
    var originalTitle: String?,
    @SerializedName("original_language")
    var originalLanguage: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("backdrop_path")
    var backdropPath: String?,
    @SerializedName("popularity")
    var popularity: Number?,
    @SerializedName("vote_count")
    var voteCount: Number?,
    @SerializedName("video")
    var video: Boolean,
    @SerializedName("vote_average")
    var voteAverage: Number
)