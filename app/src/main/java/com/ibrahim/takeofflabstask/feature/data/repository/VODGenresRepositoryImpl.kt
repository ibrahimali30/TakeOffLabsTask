package com.ibrahim.takeofflabstask.feature.data.repository

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.source.remote.VODGenresRemoteDataSource
import com.ibrahim.takeofflabstask.feature.data.model.GenresResponse
import com.ibrahim.takeofflabstask.feature.domain.repsitory.VODGenresRepository
import javax.inject.Inject


class VODGenresRepositoryImpl @Inject constructor(
    private val vodGenresRemoteDataSource: VODGenresRemoteDataSource
) : VODGenresRepository {

    override fun getVODGenres(): Single<GenresResponse> {
        return vodGenresRemoteDataSource.getVODGenres()
    }


}
