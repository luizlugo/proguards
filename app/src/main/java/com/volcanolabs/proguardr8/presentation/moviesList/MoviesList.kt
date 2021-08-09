package com.volcanolabs.proguardr8.presentation.moviesList

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.volcanolabs.proguardr8.R
import com.volcanolabs.proguardr8.databinding.FragmentMoviesListBinding
import com.volcanolabs.proguardr8.domain.entities.Movie
import com.volcanolabs.proguardr8.presentation.MainActivityListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieList : Fragment(), MoviesAdapter.MovieListListener {
    private val viewModel: MoviesListViewModel by viewModels()
    private lateinit var adapter: MoviesAdapter
    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var activityListener: MainActivityListener

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
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieListDirections.nextAction(movie)
        findNavController().navigate(action)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityListener = context as MainActivityListener
        } catch (exception: ClassCastException) {
            throw ClassCastException("${activity.toString()} must implement MainActivityListener")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.popular) {
            activityListener.setActionBarTitle(getString(R.string.popular))
            viewModel.fetchPopularMovies()
        } else if (id == R.id.top_rated) {
            activityListener.setActionBarTitle(getString(R.string.top_rated))
            viewModel.fetchTopRatedMovies()
        }

        return super.onOptionsItemSelected(item)
    }
}