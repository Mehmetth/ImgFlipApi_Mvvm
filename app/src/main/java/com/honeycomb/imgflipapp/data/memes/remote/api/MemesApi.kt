package com.honeycomb.imgflipapp.data.memes.remote.api

import com.honeycomb.imgflipapp.data.memes.remote.dto.MemesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MemesApi{
    @GET("get_memes")
    suspend fun getMemes() : Response<MemesResponse>
}