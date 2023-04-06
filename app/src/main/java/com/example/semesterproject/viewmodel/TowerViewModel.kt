package com.example.semesterproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semesterproject.data.model.TowerResponse
import com.example.semesterproject.data.repository.TowerRepository
import com.example.semesterproject.model.Tower
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TowerViewModel @Inject constructor(
    private val towerRepository: TowerRepository,
): ViewModel() {
    private val _towers = MutableStateFlow<TowerEvent>(TowerEvent.Loading)
    val towers: StateFlow<TowerEvent> = _towers

    fun fillData() {
        viewModelScope.launch {
            when (val response = towerRepository.getTowers()) {
                TowerResponse.Error -> _towers.value = TowerEvent.Failure
                is TowerResponse.Success -> _towers.value = TowerEvent.Success(response.towers)
            }
        }
    }

    sealed class TowerEvent {
        data class Success(val towers: List<Tower>) : TowerEvent()
        object Failure : TowerEvent()
        object Loading : TowerEvent()

    }
}