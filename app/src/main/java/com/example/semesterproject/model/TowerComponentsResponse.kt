package com.example.semesterproject.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class TowerComponentsResponse(
    val info: Info,
    @field:Json(name = "results")
    val towers: List<Tower>,
)

data class Info(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "prev")
    val prev: Any?,
)