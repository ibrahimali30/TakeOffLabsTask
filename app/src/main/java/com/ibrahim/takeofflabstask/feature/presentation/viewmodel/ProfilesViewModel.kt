package com.ibrahim.takeofflabstask.feature.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.ibrahim.takeofflabstask.feature.domain.interactor.GetProfilesUseCase
import javax.inject.Inject

class ProfilesViewModel @Inject constructor(
        private val refreshProfilesUseCase: GetProfilesUseCase
)
    : ViewModel() {

    val vodProfilesObservableResource = MutableLiveData<String>()

    fun getProfiles() {
        val disposable = refreshProfilesUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("TAG", "getProfiles: $it")
                }, {
                    Log.d("TAG", "getProfiles: ${it.printStackTrace()}")
                })
    }

}