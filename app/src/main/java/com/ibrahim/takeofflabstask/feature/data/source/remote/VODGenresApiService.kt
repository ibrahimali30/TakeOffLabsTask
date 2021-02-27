package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.GenresResponse
import retrofit2.http.GET

interface VODGenresApiService {

    @GET("mobile/vod/genres")
    fun getVODGenres(): Single<GenresResponse>
}