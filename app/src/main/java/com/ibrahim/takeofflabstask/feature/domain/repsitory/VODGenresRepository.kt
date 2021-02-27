package com.ibrahim.takeofflabstask.feature.domain.repsitory

import com.ibrahim.takeofflabstask.feature.data.model.ProfilesResponse
import io.reactivex.Single

interface ProfilesRepository {
    fun getProfiles(): Single<ProfilesResponse>
}