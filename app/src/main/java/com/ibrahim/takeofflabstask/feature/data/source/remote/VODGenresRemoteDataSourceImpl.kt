package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.GenresResponse
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresApiService
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresRemoteDataSource
import javax.inject.Inject

class VODGenresRemoteDataSourceImpl @Inject constructor(private val vodGenresApiService: VODGenresApiService)
    : VODGenresRemoteDataSource {
    override fun getVODGenres(language: String):
            Single<GenresResponse> = vodGenresApiService.getVODGenres()
}