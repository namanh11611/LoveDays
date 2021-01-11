package com.namanh.lovedays.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.namanh.lovedays.core.base.BaseViewModel
import com.namanh.lovedays.core.interactor.UseCase.None
import javax.inject.Inject

class MemoriesViewModel
@Inject constructor(private val getMemories: GetMemories) : BaseViewModel() {

    private val _memories: MutableLiveData<List<MemoryView>> = MutableLiveData()
    val memories: LiveData<List<MemoryView>> = _memories

    fun loadMemories() = getMemories(None()) { it.fold(::handleFailure, ::handleMovieList) }

    private fun handleMovieList(movies: List<Memory>) {
        _memories.value = movies.map { MemoryView(it.id, it.title, it.description, it.day, it.month, it.year) }
    }
}