package com.namanh.lovedays.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.namanh.lovedays.features.MemoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MemoriesViewModel::class)
    abstract fun bindsMemoriesViewModel(memoriesViewModel: MemoriesViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(MovieDetailsViewModel::class)
//    abstract fun bindsMovieDetailsViewModel(movieDetailsViewModel: MovieDetailsViewModel): ViewModel
}