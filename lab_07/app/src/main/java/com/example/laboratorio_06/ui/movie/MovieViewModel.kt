package com.example.laboratorio_06.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio_06.MovieReviewerApplication
import com.example.laboratorio_06.data.model.MovieModel
import com.example.laboratorio_06.data.qualification
import com.example.laboratorio_06.databinding.FragmentNewMovieBinding
import com.example.laboratorio_06.repositories.MovieRepository

class MovieViewModel(private val  repository: MovieRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualication = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies(movies: MutableList<MovieModel>) = repository.getMovies()

    private fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    fun createMovie() {
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualication.value!!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean {
        when{
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualication.value.isNullOrEmpty() -> return false
        }
        return true
    }

    private fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualication.value = ""
    }

    fun  clearStatus(){
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val  app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    private fun  observerStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    movieViewModel.clearStatus()
                }
                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, movieViewModel.getMovies().toString())

                    movieViewModel.clearStatus()
                    finadNavController().popBackStack()
                }
            }

        }
    }

}