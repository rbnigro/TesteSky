package com.ronney.testesky.presentation.movies

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ronney.testesky.R
import com.ronney.testesky.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movies.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MoviesActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        toolBar(toolbarMain, R.string.movies_title)

        val viewModel: MoviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)

        viewModel.moviesLiveData.observe(this, Observer {
            it?.let { movies ->
                with(recyclerMovies) {
                    layoutManager = LinearLayoutManager(this@MoviesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = MoviesAdapter
                }
            }
        }

        )
    }
}