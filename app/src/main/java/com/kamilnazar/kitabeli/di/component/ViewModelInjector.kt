package com.kamilnazar.kitabeli.di.component

import com.kamilnazar.kitabeli.di.modules.NetworkModule
import com.kamilnazar.kitabeli.ui.base.BaseViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(viewModel: BaseViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}