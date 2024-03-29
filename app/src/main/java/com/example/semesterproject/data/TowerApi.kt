package com.example.semesterproject.data

import com.example.semesterproject.model.Tower
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TowerApi {

    @GET("/api/btd/v3/towers")
    suspend fun getTowers(): Response<List<Tower>>

    @GET("/api/btd/v3/tower/{tower-id}")
    suspend fun getSpecificTower(@Path(value = "tower-id") name: String): Response<List<Tower>>

    @GET("/images/btd/towers/{tower-id}/tower.png")
    suspend fun getTowerImage(@Path(value = "tower-id") name: String): Response<List<Tower>>
}