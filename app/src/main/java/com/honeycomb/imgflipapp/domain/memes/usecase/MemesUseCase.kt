package com.honeycomb.imgflipapp.domain.memes.usecase

import com.honeycomb.imgflipapp.data.memes.remote.dto.MemesResponse
import com.honeycomb.imgflipapp.domain.common.BaseResult
import com.honeycomb.imgflipapp.domain.memes.DataEntity
import com.honeycomb.imgflipapp.domain.memes.MemesRepository
import com.honeycomb.imgflipapp.domain.memes.entity.MemesEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MemesUseCase @Inject constructor(private val memesRepository: MemesRepository) {
    suspend fun execute(): Flow<BaseResult<DataEntity, MemesResponse>> {
        return memesRepository.getMemes()
    }
}