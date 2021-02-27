package com.ibrahim.takeofflabstask.feature.domain.repsitory

import com.ibrahim.takeofflabstask.feature.data.model.GenresResponse
import io.reactivex.Single

interface VODGenresRepository {
    fun getVODGenres(): Single<GenresResponse>
}