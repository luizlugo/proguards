package com.volcanolabs.proguardr8.presentation.moviesList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.volcanolabs.proguardr8.R
import com.volcanolabs.proguardr8.domain.entities.Movie
import com.volcanolabs.proguardr8.utils.API_KEY
import com.volcanolabs.proguardr8.utils.POSTER_PATH_IMAGE

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {
    private var movies: List<Movie>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movies_list_item, parent, false)

        return MoviesHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        movies?.run {
            holder.bind(this.get(position))
        }
    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    class MoviesHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivMovieImage: ImageView = itemView.findViewById(R.id.iv_movie_image);
        private var tvOverview: TextView = itemView.findViewById(R.id.tv_overview)

        fun bind(movie: Movie) {
            val path = "${POSTER_PATH_IMAGE}${movie.posterPath}?api_key=${API_KEY}"

            Picasso.get()
                .load(path)
                .into(ivMovieImage)

            tvOverview.text = movie.overview
        }
    }
}