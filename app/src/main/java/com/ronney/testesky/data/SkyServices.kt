package com.ronney.testesky.data

import com.ronney.testesky.data.response.MovieBodyResponse
import retrofit2.Call
import retrofit2.http.GET

interface SkyServices {
    @GET("Movies")
    fun getMovies(): Call<MovieBodyResponse>
}