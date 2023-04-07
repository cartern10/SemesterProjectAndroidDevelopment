package com.example.semesterproject.data.repository

import com.example.semesterproject.data.TowerApi
import com.example.semesterproject.data.model.TowerResponse
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
    suspend fun getTowerImage(towerName: String): TowerResponse {
        val towerImageList = towerApi.getTowers();
        for (i in 0 until towerImageList.size){
            getTowerImage()
        }
        val result = towerApi.getTowerImage(towerName)
        return if (result.isSuccessful){
            TowerResponse.Success(result.body() ?: emptyList())
        } else {
            TowerResponse.Error
        }
    }

}

