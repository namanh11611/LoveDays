package com.namanh.lovedays.features

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MemoriesApi {
    companion object {
        private const val PARAM_MOVIE_ID = "movieId"
        private const val MOVIES = "movies.json"
        private const val MOVIE_DETAILS = "movie_0{$PARAM_MOVIE_ID}.json"
    }

    @GET(MOVIES) fun memories(): Call<List<MemoryEntity>>
}