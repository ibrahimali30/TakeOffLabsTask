package com.ibrahim.takeofflabstask.feature.data.source.remote

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.model.ProfilesResponse
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesApiService
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesRemoteDataSource
import javax.inject.Inject

class ProfilesRemoteDataSourceImpl @Inject constructor(private val vodProfilesApiService: ProfilesApiService)
    : ProfilesRemoteDataSource {
    override fun getProfiles(language: String):
            Single<ProfilesResponse> = vodProfilesApiService.getProfiles()
}