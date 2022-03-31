package com.honeycomb.imgflipapp.domain.memes

import com.honeycomb.imgflipapp.data.memes.remote.dto.MemesResponse
import com.honeycomb.imgflipapp.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow

interface MemesRepository {
    suspend fun getMemes() : Flow<BaseResult<DataEntity, MemesResponse>>
}