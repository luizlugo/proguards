package com.volcanolabs.proguardr8.presentation.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.volcanolabs.proguardr8.databinding.FragmentMovieDetailsBinding
import com.volcanolabs.proguardr8.utils.API_KEY
import com.volcanolabs.proguardr8.utils.POSTER_PATH_IMAGE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetails : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MovieDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        val safeArgs: MovieDetailsArgs by navArgs()
        viewModel.setMovie(safeArgs.movie)
        viewModel.movie.observe(viewLifecycleOwner, { movie ->
            binding.tvMovieTitle.text = movie.title
            binding.tvMovieOverview.text = movie.overview
            val path = "$POSTER_PATH_IMAGE${movie.posterPath}?api_key=$API_KEY"
            Picasso.get()
                .load(path)
                .into(binding.ivMovieImage)
        })
        return binding.root
    }
}