package com.namanh.lovedays.features

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoriesService
@Inject constructor(retrofit: Retrofit) : MemoriesApi {
    private val moviesApi by lazy { retrofit.create(MemoriesApi::class.java) }

    override fun memories() = moviesApi.memories()
}
