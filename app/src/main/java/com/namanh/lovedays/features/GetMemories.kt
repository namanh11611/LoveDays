package com.namanh.lovedays.features

import com.namanh.lovedays.core.interactor.UseCase
import javax.inject.Inject

class GetMemories
@Inject constructor(private val memoriesRepository: MemoriesRepository) : UseCase<List<Memory>, UseCase.None>() {

    override suspend fun run(params: None) = memoriesRepository.memories()
}