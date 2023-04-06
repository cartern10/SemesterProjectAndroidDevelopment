package com.example.semesterproject.model


import com.squareup.moshi.Json

class Tower : ArrayList<Tower.TowerItem>(){
    data class TowerItem(
        @Json(name = "cost")
        val cost: Cost,
        @Json(name = "defaultHotkey")
        val defaultHotkey: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "footprint")
        val footprint: Int,
        @Json(name = "id")
        val id: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "paths")
        val paths: Paths,
        @Json(name = "stats")
        val stats: Stats,
        @Json(name = "type")
        val type: String
    ) {
        data class Cost(
            @Json(name = "easy")
            val easy: Int,
            @Json(name = "hard")
            val hard: Int,
            @Json(name = "impoppable")
            val impoppable: Int,
            @Json(name = "medium")
            val medium: Int
        )

        data class Paths(
            @Json(name = "paragon")
            val paragon: Paragon?,
            @Json(name = "path1")
            val path1: List<Path1>,
            @Json(name = "path2")
            val path2: List<Path2>,
            @Json(name = "path3")
            val path3: List<Path3>
        ) {
            data class Paragon(
                @Json(name = "cost")
                val cost: Cost,
                @Json(name = "description")
                val description: String,
                @Json(name = "effects")
                val effects: List<String>,
                @Json(name = "name")
                val name: String,
                @Json(name = "source")
                val source: String,
                @Json(name = "unlockXp")
                val unlockXp: Int
            ) {
                data class Cost(
                    @Json(name = "easy")
                    val easy: Int,
                    @Json(name = "hard")
                    val hard: Int,
                    @Json(name = "impoppable")
                    val impoppable: Int,
                    @Json(name = "medium")
                    val medium: Int
                )
            }

            data class Path1(
                @Json(name = "cost")
                val cost: Cost,
                @Json(name = "description")
                val description: String,
                @Json(name = "effects")
                val effects: List<String>,
                @Json(name = "name")
                val name: String,
                @Json(name = "source")
                val source: String,
                @Json(name = "unlockXp")
                val unlockXp: Int
            ) {
                data class Cost(
                    @Json(name = "easy")
                    val easy: Int,
                    @Json(name = "hard")
                    val hard: Int,
                    @Json(name = "impoppable")
                    val impoppable: Int,
                    @Json(name = "medium")
                    val medium: Int
                )
            }

            data class Path2(
                @Json(name = "cost")
                val cost: Cost,
                @Json(name = "description")
                val description: String,
                @Json(name = "effects")
                val effects: List<String>,
                @Json(name = "name")
                val name: String,
                @Json(name = "source")
                val source: String,
                @Json(name = "unlockXp")
                val unlockXp: Int
            ) {
                data class Cost(
                    @Json(name = "easy")
                    val easy: Int,
                    @Json(name = "hard")
                    val hard: Int,
                    @Json(name = "impoppable")
                    val impoppable: Int,
                    @Json(name = "medium")
                    val medium: Int
                )
            }

            data class Path3(
                @Json(name = "cost")
                val cost: Cost,
                @Json(name = "description")
                val description: String,
                @Json(name = "effects")
                val effects: List<String>,
                @Json(name = "name")
                val name: String,
                @Json(name = "source")
                val source: String,
                @Json(name = "unlockXp")
                val unlockXp: Int
            ) {
                data class Cost(
                    @Json(name = "easy")
                    val easy: Int,
                    @Json(name = "hard")
                    val hard: Int,
                    @Json(name = "impoppable")
                    val impoppable: Int,
                    @Json(name = "medium")
                    val medium: Int
                )
            }
        }

        data class Stats(
            @Json(name = "attackSpeed")
            val attackSpeed: String,
            @Json(name = "damage")
            val damage: String,
            @Json(name = "pierce")
            val pierce: String,
            @Json(name = "range")
            val range: String,
            @Json(name = "special")
            val special: List<Special>?,
            @Json(name = "type")
            val type: String
        ) {
            data class Special(
                @Json(name = "name")
                val name: String,
                @Json(name = "value")
                val value: String
            )
        }
    }
}