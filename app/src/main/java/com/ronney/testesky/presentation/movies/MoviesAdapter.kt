package com.ronney.testesky.presentation.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronney.testesky.R
import com.ronney.testesky.data.model.Movie
import com.ronney.testesky.data.response.MovieBodyResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val movies: List<Movie>, val onItemClickListener: ((movie: Movie) -> Unit)) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount() = movies.count()

    override fun onBindViewHolder(viewHolder: MovieViewHolder, position: Int) {
        viewHolder.bindView(movies[position])
    }

    class MovieViewHolder(itemView: View, private val onItemClickListener: ((movie: Movie) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val displayTitle = itemView.textTitle
        // private val coverUrl = itemView.textCoverUrl LER PATH

        fun bindView(movie: Movie) {
            displayTitle.text = movie.title
            //coverUrl.text = movie.coverUrl

              itemView.setOnClickListener {
                  onItemClickListener.invoke(movie)
              }
        }
    }
}