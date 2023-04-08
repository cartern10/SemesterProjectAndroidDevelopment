package com.example.semesterproject.data.repository

import com.example.semesterproject.data.model.TowerResponse

interface TowerRepository {
    suspend fun getTowers(): TowerResponse
    suspend fun getTowerImage(name: String): TowerResponse

    suspend fun getSpecificTower(name: String): TowerResponse

}