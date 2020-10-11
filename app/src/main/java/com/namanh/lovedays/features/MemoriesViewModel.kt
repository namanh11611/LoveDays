package com.namanh.lovedays.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namanh.lovedays.core.base.BaseViewModel
import javax.inject.Inject

class MemoriesViewModel
@Inject constructor(private val getMemories: GetMemories) : BaseViewModel() {

    private val _movies: MutableLiveData<List<MemoryView>> = MutableLiveData()
    val movies: LiveData<List<MemoryView>> = _movies

//    fun loadMovies() = getMovies(None()) { it.fold(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Memory>) {
        _movies.value = movies.map { MemoryView(it.id, it.title, it.description, it.day, it.month, it.year) }
    }
}