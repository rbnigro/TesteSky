package com.ronney.testesky.presentation.movies

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ronney.testesky.R
import com.ronney.testesky.data.model.Movie
import com.ronney.testesky.presentation.base.BaseActivity
import com.ronney.testesky.presentation.details.MovieDetailsActivity
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MoviesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        toolbarMain.title = getString(R.string.movies_title)
        setSupportActionBar(toolbarMain)

        val viewModel: MoviesViewModel =
            ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies) {
                    layoutManager = GridLayoutManager(this@MoviesActivity, 2)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter(movies) { movie ->
                        val intent =
                        MovieDetailsActivity.getStartIntrent(this@MoviesActivity,
                        movie.title,
                            movie.duration,
                            movie.releaseYear,
                            movie.overview
                            )
                        this@MoviesActivity.startActivity(intent)
                    }
                }
            }
        })
        viewModel.getMovies()
    }
}