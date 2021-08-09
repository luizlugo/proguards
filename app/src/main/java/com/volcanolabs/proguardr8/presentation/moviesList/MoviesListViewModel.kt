package com.volcanolabs.proguardr8.presentation.moviesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volcanolabs.proguardr8.domain.entities.MoviesWrapper
import com.volcanolabs.proguardr8.domain.interactors.GetPopularMovies
import com.volcanolabs.proguardr8.domain.interactors.GetTopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMovies,
    private val getTopRatedMovies: GetTopRatedMovies
) : ViewModel() {
    private val _movies = MutableLiveData<MoviesWrapper>()
    val movies: LiveData<MoviesWrapper> = _movies

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            val moviesResponse = getPopularMovies.execute()
            _movies.value = moviesResponse
        }
    }

    fun fetchTopRatedMovies() {
        viewModelScope.launch {
            val moviesResponse = getTopRatedMovies.execute()
            _movies.value = moviesResponse
        }
    }
}