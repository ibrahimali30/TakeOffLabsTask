package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.ProfilesResponse

interface ProfilesRemoteDataSource {
    fun getProfiles(language: String = ""): Single<ProfilesResponse>
}