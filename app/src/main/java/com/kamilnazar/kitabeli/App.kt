package com.kamilnazar.kitabeli

import android.app.Application
import com.facebook.stetho.Stetho
import com.kamilnazar.kitabeli.di.component.AppComponent
import com.kamilnazar.kitabeli.di.component.DaggerAppComponent
import com.kamilnazar.kitabeli.di.modules.AppModule
import com.kamilnazar.kitabeli.di.modules.DbModule
import com.kamilnazar.kitabeli.di.modules.NetworkModule
import com.kamilnazar.kitabeli.di.modules.RepoModule
import timber.log.Timber

class App : Application() {

    val appComponent by lazy(LazyThreadSafetyMode.NONE) { buildAppComponent() }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }

    private fun buildAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule(BASE_URL))
            .appModule(AppModule(this))
            .dbModule(DbModule())
            .repoModule(RepoModule())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://walaba.id/api/v1/"
    }
}