package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.GenresResponse

interface VODGenresRemoteDataSource {
    fun getVODGenres(language: String = ""): Single<GenresResponse>
}