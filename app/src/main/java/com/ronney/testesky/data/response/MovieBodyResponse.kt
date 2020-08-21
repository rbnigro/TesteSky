package com.ronney.testesky.data.response

import com.ronney.testesky.data.model.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieBodyResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "cover_url")
    val coverUrl: String,
    @Json(name = "overview")
    val overview: String,
    @Json(name = "duration")
    val duration: String,
    @Json(name = "release_year")
    val releaseYear: String
) {
    fun getMovieModel() = Movie(
        id = this.id,
        title = this.title,
        coverUrl = this.coverUrl,
        overview = this.overview,
        duration = this.duration,
        releaseYear = this.releaseYear
    )
}