package com.ibrahim.takeofflabstask.feature.presentation.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import com.ibrahim.takeofflabstask.feature.data.repository.VODGenresRepositoryImpl
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresRemoteDataSource
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresRemoteDataSourceImpl
import com.ibrahim.takeofflabstask.feature.domain.repsitory.VODGenresRepository
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class VODGenresModule {

    @Provides
    fun providesVODGenresRemoteDataSource(vodGenresRemoteDataSourceImpl: VODGenresRemoteDataSourceImpl): VODGenresRemoteDataSource = vodGenresRemoteDataSourceImpl

    @Provides
    fun providesVODGenresRepository(vodGenresRepositoryImpl: VODGenresRepositoryImpl): VODGenresRepository = vodGenresRepositoryImpl

    @Provides
    fun providesVODGenresApiService(): VODGenresApiService {
        val okHttpClient = getCommonOkHttpClient()

        val builder = Retrofit.Builder()

        val gson = GsonBuilder().enableComplexMapKeySerialization()
            .setLenient()
            .create()

        builder.baseUrl("https://www.google.com.eg/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        builder.client(okHttpClient)

        val retrofit = builder.build()
        return retrofit.create(VODGenresApiService::class.java)
    }

    private fun getCommonOkHttpClient(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()

        httpClient.connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        return httpClient.build()
    }
}