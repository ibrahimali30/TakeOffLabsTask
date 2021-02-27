package com.ibrahim.takeofflabstask.feature.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.ibrahim.takeofflabstask.feature.domain.interactor.GetVODGenresUseCase
import javax.inject.Inject

class VODGenrsViewModel @Inject constructor(
        private val refreshVODGenresUseCase: GetVODGenresUseCase
)
    : ViewModel() {

    val vodGenresObservableResource = MutableLiveData<String>()

    fun getVODGenres() {
        val disposable = refreshVODGenresUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("TAG", "getVODGenres: $it")
                }, {
                    Log.d("TAG", "getVODGenres: ${it.printStackTrace()}")
                })
    }

}