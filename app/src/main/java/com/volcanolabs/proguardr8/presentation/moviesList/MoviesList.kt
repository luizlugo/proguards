package com.volcanolabs.proguardr8.presentation.moviesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.volcanolabs.proguardr8.databinding.FragmentMoviesListBinding
import com.volcanolabs.proguardr8.domain.entities.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieList : Fragment(), MoviesAdapter.MovieListListener {
    private val viewModel: MoviesListViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter
    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = MoviesAdapter(this)
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        viewModel.movies.observe(viewLifecycleOwner, { moviesWrapper ->
            adapter.setData(moviesWrapper.movies)
        })
        binding.rvMovies.adapter = adapter
        return binding.root
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieListDirections.nextAction(movie)
        findNavController().navigate(action)
    }
}