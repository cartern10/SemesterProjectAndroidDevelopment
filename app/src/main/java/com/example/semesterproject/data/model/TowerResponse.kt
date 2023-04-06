package com.example.semesterproject.data.model

import com.example.semesterproject.model.Tower

sealed class TowerResponse{
    data class Success(val towers: List<Tower>) : TowerResponse()
    object Error : TowerResponse()
}
