package com.example.semesterproject.data.repository

import com.example.semesterproject.data.TowerApi
import com.example.semesterproject.data.model.TowerResponse
import com.example.semesterproject.di.AppModule
import com.example.semesterproject.model.Tower
import javax.inject.Inject


class TowerRepositoryImpl @Inject constructor(
    private val towerApi: TowerApi,
) : TowerRepository {
    override suspend fun getTowers(): TowerResponse {
        val result = towerApi.getTowers()
        return if (result.isSuccessful) {
            TowerResponse.Success(result.body() ?: emptyList())
        } else {
            TowerResponse.Error
        }
    }
    override suspend fun getTowerImage(towerName: String): TowerResponse {
        val result = towerApi.getTowerImage(towerName)
        return if (result.isSuccessful) {
            TowerResponse.Success(result.body() ?: emptyList())
        } else {
            TowerResponse.Error
        }
    }

    override suspend fun getSpecificTower(name: String): TowerResponse {
        val result = towerApi.getSpecificTower(name)
        return if (result.isSuccessful){
            TowerResponse.Success(result.body() ?: emptyList())
        }else {
            TowerResponse.Error
        }
    }

}

