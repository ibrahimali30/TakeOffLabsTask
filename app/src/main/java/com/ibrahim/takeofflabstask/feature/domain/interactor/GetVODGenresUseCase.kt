package com.ibrahim.takeofflabstask.feature.domain.interactor

import com.ibrahim.takeofflabstask.feature.domain.repsitory.ProfilesRepository
import javax.inject.Inject

class GetProfilesUseCase @Inject constructor(private val profilesRepository: ProfilesRepository) {

    fun execute() = profilesRepository.getProfiles()
}