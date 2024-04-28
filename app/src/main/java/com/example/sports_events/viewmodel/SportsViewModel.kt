package com.example.sports_events.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Sport
import com.example.domain.usecase.GetSportsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SportsViewModel(
    private val getSportsUseCase: GetSportsUseCase
): ViewModel() {

    private val _sports = MutableStateFlow<List<Sport>>(value = listOf())
    private val sports = _sports.asStateFlow()

    init {
        getSports()
    }

    private fun getSports() {
        viewModelScope.launch {
            _sports.value = getSportsUseCase.invoke()
        }
    }

}