package com.kamilnazar.kitabeli.di.modules

import com.kamilnazar.kitabeli.data.api.KitabeliApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl: String) {
    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @Singleton
    internal fun provideRetrofitInterface(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    internal fun providePostApi(retrofit: Retrofit): KitabeliApi {
        return retrofit.create(KitabeliApi::class.java)
    }
}