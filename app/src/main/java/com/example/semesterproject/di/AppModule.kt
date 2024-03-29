package com.example.semesterproject.di

import com.example.semesterproject.data.TowerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesTowerApi(): TowerApi =
        Retrofit.Builder()
            .baseUrl("https://statsnite.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}