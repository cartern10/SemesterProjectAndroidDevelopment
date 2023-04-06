package com.example.semesterproject.di

import com.example.semesterproject.data.repository.TowerRepository
import com.example.semesterproject.data.repository.TowerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTowerRepository(
        TowerRepositoryImpl: TowerRepositoryImpl,
    ): TowerRepository
}