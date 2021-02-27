package com.ibrahim.takeofflabstask.feature.domain.interactor

import com.ibrahim.takeofflabstask.feature.domain.repsitory.VODGenresRepository
import javax.inject.Inject

class GetVODGenresUseCase @Inject constructor(private val vodGenresRepository: VODGenresRepository) {

    fun execute() = vodGenresRepository.getVODGenres()
}