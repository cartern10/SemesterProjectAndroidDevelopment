package com.example.semesterproject.data

import com.example.semesterproject.model.TowerComponentsResponse
import retrofit2.Response
import retrofit2.http.GET

interface TowerApi {

    @GET("/api/btd/v3/towers")
    suspend fun getTowers(): Response<TowerComponentsResponse>
}