package com.ronney.testesky.data

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private const val urlSky = "https://sky-exercise.herokuapp.com/api/Movies/"

    private fun initRetrofit(pURL: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(pURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val serviceMovie: SkyServices = initRetrofit(urlSky).create(SkyServices::class.java)
}