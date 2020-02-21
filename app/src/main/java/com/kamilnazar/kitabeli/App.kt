package com.kamilnazar.kitabeli

import android.app.Application
import com.kamilnazar.kitabeli.di.component.AppComponent
import com.kamilnazar.kitabeli.di.component.DaggerAppComponent
import com.kamilnazar.kitabeli.di.modules.NetworkModule

class App : Application() {
    val appComponent by lazy(LazyThreadSafetyMode.NONE) { buildAppComponent() }

    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule(BASE_URL))
            .build()
    }

    companion object {
        private const val BASE_URL = "https://walaba.id/api/v1/"
    }
}