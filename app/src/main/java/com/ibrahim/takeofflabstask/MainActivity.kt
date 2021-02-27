package com.ibrahim.takeofflabstask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.takeofflabstask.base.ViewModelFactory
import com.ibrahim.takeofflabstask.feature.presentation.viewmodel.VODGenrsViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory<VODGenrsViewModel>
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(VODGenrsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getVODGenres()
    }
}