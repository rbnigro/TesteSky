package com.ronney.testesky.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ronney.testesky.R
import com.ronney.testesky.data.ApiService
import com.ronney.testesky.data.model.Movie
import com.ronney.testesky.data.response.MovieBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() { // não trazer activity

    private val _coverUrl = MutableLiveData<String>()
    val coverUrl: LiveData<String>
        get() = _coverUrl

    init {
        _coverUrl.value = ""
    }

    val moviesLiveData: MutableLiveData<List<Movie>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getMovies() {
        val call: Call<List<MovieBodyResponse>> = ApiService.serviceMovie.getMovies()
        call.enqueue(object : Callback<List<MovieBodyResponse>> {
            override fun onResponse(
                call: Call<List<MovieBodyResponse>>, response: Response<List<MovieBodyResponse>>
            ) {
                when {
                    response.isSuccessful -> {
                        val movies: MutableList<Movie> = mutableListOf()

                        response.body()?.let { movieBodyResponse ->
                            for (result in movieBodyResponse) {
                                val movie =
                                    Movie(
                                        result.id,
                                        result.title,
                                        result.coverUrl,
                                        result.overview,
                                        result.duration,
                                        result.releaseYear
                                    )

                                this@MoviesViewModel._coverUrl.value = movie.coverUrl

                                movies.add(movie)
                            }
                        }

                        moviesLiveData.value = movies
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_MOVIES, null)
                    }
                    response.code() == 401 -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_401)
                    }
                    response.code() == 404 -> {
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_404)
                    }
                    else -> {
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.error_500_generic)
                    }
                }
            }

            override fun onFailure(call: Call<List<MovieBodyResponse>>, t: Throwable) {
                viewFlipperLiveData.value = Pair(VIEW_FLIPPER_ERROR, R.string.error_500_generic)
            }
        })
    }

    companion object {
        // posição 0 é o loder default
        private const val VIEW_FLIPPER_MOVIES = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}