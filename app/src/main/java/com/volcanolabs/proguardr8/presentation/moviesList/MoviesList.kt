package com.volcanolabs.proguardr8.presentation.moviesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.volcanolabs.proguardr8.databinding.FragmentMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [MovieList.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MovieList : Fragment() {
    private val viewModel: MoviesListViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter
    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = MoviesAdapter()
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        viewModel.movies.observe(viewLifecycleOwner, {moviesWrapper ->
            adapter.setData(moviesWrapper.movies)
        })
        binding.rvMovies.adapter = adapter
        return binding.root
    }
}