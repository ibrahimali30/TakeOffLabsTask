package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.ProfilesResponse
import retrofit2.http.GET

interface ProfilesApiService {

    @GET("take_home_sample_profiles")
    fun getProfiles(): Single<ProfilesResponse>
}