package com.honeycomb.imgflipapp.data.memes

import com.honeycomb.imgflipapp.data.common.NetworkModule
import com.honeycomb.imgflipapp.data.memes.remote.api.MemesApi
import com.honeycomb.imgflipapp.data.memes.repository.MemesRepositoryImpl
import com.honeycomb.imgflipapp.domain.memes.MemesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class MemesModule {
    @Singleton
    @Provides
    fun provideProductApi(retrofit: Retrofit) : MemesApi {
        return retrofit.create(MemesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductRepository(memesApi: MemesApi) : MemesRepository {
        return MemesRepositoryImpl(memesApi)
    }
}