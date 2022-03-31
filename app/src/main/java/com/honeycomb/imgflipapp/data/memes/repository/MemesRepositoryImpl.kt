package com.honeycomb.imgflipapp.data.memes.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.honeycomb.imgflipapp.data.memes.remote.api.MemesApi
import com.honeycomb.imgflipapp.data.memes.remote.dto.MemesResponse
import com.honeycomb.imgflipapp.domain.common.BaseResult
import com.honeycomb.imgflipapp.domain.memes.DataEntity
import com.honeycomb.imgflipapp.domain.memes.Memes
import com.honeycomb.imgflipapp.domain.memes.entity.MemesEntity
import com.honeycomb.imgflipapp.domain.memes.MemesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MemesRepositoryImpl @Inject constructor(private val memesApi: MemesApi) :
    MemesRepository {
    override suspend fun getMemes(): Flow<BaseResult<DataEntity, MemesResponse>> {
        return flow {
            val response = memesApi.getMemes()
            if (response.isSuccessful){
                val body = response.body()!!

                val memesList = mutableListOf<Memes>()
                body.data.memes.forEach { item ->
                    memesList.add(Memes(item.id,item.name,item.url,item.width,item.height,item.box_count))
                }

                emit(BaseResult.Success(DataEntity(memesList)))
            }else{
                val type = object : TypeToken<MemesResponse>(){}.type
                val err = Gson().fromJson<MemesResponse>(response.errorBody()!!.charStream(), type)!!
                emit(BaseResult.Error(err))
            }
        }
    }
}