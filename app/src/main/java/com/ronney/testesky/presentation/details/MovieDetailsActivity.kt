package com.ronney.testesky.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ronney.testesky.R
import com.ronney.testesky.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class MovieDetailsActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        toolBar(toolbarMain, R.string.movie_details_title, true)

        movieDetailsTitle.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_TITLE)
        movieDetailsDuration.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_DURATION)
        movieDetailsReleaseYear.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_RELEASE_YEAR)
        movieDetailsOverview.text = intent.getStringExtra(MovieDetailsActivity.EXTRA_OVERVIEW)
    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DURATION = "EXTRA_DURATION"
        private const val EXTRA_RELEASE_YEAR = "EXTRA_RELEASE_YEAR"
        private const val EXTRA_OVERVIEW = "EXTRA_OVERVIEW"

        fun getStartIntrent(context: Context,
                            title: String,
                            duration: String,
                            relearYear: String,
                            overView: String): Intent {
            return Intent(context, MovieDetailsActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
                putExtra(EXTRA_DURATION, duration)
                putExtra(EXTRA_RELEASE_YEAR, relearYear)
                putExtra(EXTRA_OVERVIEW, overView)
                // criação Intent destino com campos preenchidos
            }
        }
    }
}