package com.ibrahim.takeofflabstask.feature.presentation.di

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import com.ibrahim.takeofflabstask.feature.data.repository.ProfilesRepositoryImpl
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesRemoteDataSource
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesRemoteDataSourceImpl
import com.ibrahim.takeofflabstask.feature.domain.repsitory.ProfilesRepository
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ProfilesModule {

    @Provides
    fun providesProfilesRemoteDataSource(profilesRemoteDataSourceImpl: ProfilesRemoteDataSourceImpl): ProfilesRemoteDataSource = profilesRemoteDataSourceImpl

    @Provides
    fun providesProfilesRepository(profilesRepositoryImpl: ProfilesRepositoryImpl): ProfilesRepository = profilesRepositoryImpl

    @Provides
    fun providesProfilesApiService(): ProfilesApiService {
        val okHttpClient = getCommonOkHttpClient()

        val builder = Retrofit.Builder()

        val gson = GsonBuilder().enableComplexMapKeySerialization()
            .setLenient()
            .create()

        builder.baseUrl("https://www.plugco.in/public/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        builder.client(okHttpClient)

        val retrofit = builder.build()
        return retrofit.create(ProfilesApiService::class.java)
    }

    private fun getCommonOkHttpClient(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()

        httpClient.connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)

        return httpClient.build()
    }
}