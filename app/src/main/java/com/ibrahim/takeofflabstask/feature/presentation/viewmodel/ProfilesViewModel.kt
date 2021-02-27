package com.ibrahim.takeofflabstask.feature.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.takeofflabstask.feature.data.model.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.ibrahim.takeofflabstask.feature.domain.interactor.GetProfilesUseCase
import javax.inject.Inject

class ProfilesViewModel @Inject constructor(
        private val refreshProfilesUseCase: GetProfilesUseCase
)
    : ViewModel() {

    val profilesObservableResource = MutableLiveData<List<Profile>>()

    fun getProfiles() {
        val disposable = refreshProfilesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("TAG", "getProfiles: $it")
                    profilesObservableResource.value = it.profiles
                }, {
                    Log.d("TAG", "getProfiles: ${it.printStackTrace()}")
                })
    }

}