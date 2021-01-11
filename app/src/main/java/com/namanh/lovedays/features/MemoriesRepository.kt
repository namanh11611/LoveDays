package com.namanh.lovedays.features

import com.namanh.lovedays.core.base.NetworkHandler
import com.namanh.lovedays.core.exception.Failure
import com.namanh.lovedays.core.functional.Either
import retrofit2.Call
import javax.inject.Inject

interface MemoriesRepository {

    fun memories(): Either<Failure, List<Memory>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: MemoriesService) : MemoriesRepository {

        override fun memories(): Either<Failure, List<Memory>> {
            return when (networkHandler.isConnected) {
                true -> request(service.memories(), { it.map { memoryEntity -> memoryEntity.toMemory() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}