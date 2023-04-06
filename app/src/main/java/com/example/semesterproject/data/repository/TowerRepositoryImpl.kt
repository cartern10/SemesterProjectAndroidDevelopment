package com.example.semesterproject.data.repository

import com.example.semesterproject.data.TowerApi
import com.example.semesterproject.data.model.TowerResponse
import javax.inject.Inject


class TowerRepositoryImpl @Inject constructor(
    private val towerApi: TowerApi,
) : TowerRepository {
    override suspend fun getTowers(): TowerResponse {
        val result = towerApi.getTowers()
        return if (result.isSuccessful) {
            TowerResponse.Success(result.body()?.towers ?: emptyList())
        } else {
            TowerResponse.Error
        }
    }
}
