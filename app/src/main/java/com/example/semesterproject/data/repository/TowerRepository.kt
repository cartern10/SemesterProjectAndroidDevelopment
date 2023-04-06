package com.example.semesterproject.data.repository

import com.example.semesterproject.data.model.TowerResponse

interface TowerRepository {
    suspend fun getTowers(): TowerResponse
}