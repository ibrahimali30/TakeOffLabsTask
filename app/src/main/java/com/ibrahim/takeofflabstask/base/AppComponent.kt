package com.ibrahim.takeofflabstask.base

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.takeofflabstask.MainActivity
import com.ibrahim.takeofflabstask.feature.presentation.di.ProfilesModule
import dagger.BindsInstance
import dagger.Component
import dagger.Lazy
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,ActivityBuilder::class]
)


interface AppComponent {

    fun inject(app: AppAplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector( modules = [ProfilesModule::class])
    abstract fun bindMainActivity(): MainActivity
}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory<T : ViewModel> @Inject constructor(private val viewModel: Lazy<T>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModel.get() as T

}
