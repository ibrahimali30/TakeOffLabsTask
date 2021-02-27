package com.ibrahim.takeofflabstask.feature.data.repository

import io.reactivex.Single
import com.ibrahim.takeofflabstask.feature.data.source.remote.ProfilesRemoteDataSource
import com.ibrahim.takeofflabstask.feature.data.model.ProfilesResponse
import com.ibrahim.takeofflabstask.feature.domain.repsitory.ProfilesRepository
import javax.inject.Inject


class ProfilesRepositoryImpl @Inject constructor(
    private val profilesRemoteDataSource: ProfilesRemoteDataSource
) : ProfilesRepository {

    override fun getProfiles(): Single<ProfilesResponse> {
        return profilesRemoteDataSource.getProfiles()
    }


}
