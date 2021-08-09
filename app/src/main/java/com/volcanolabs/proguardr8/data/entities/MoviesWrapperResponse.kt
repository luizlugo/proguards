package com.volcanolabs.proguardr8.data.entities

import com.google.gson.annotations.SerializedName

data class MoviesWrapperResponse(
    @SerializedName("page")
    var page: Number,
    @SerializedName("results")
    var movies: List<Movie>,
    @SerializedName("total_pages")
    var totalPages: Number,
    @SerializedName("total_results")
    var totalResults: Number
)