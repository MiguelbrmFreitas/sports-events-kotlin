package com.example.sports_events.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Sport
import com.example.domain.usecase.GetSportsUseCase
import com.example.sports_events.helper.mappers.toSportUi
import com.example.sports_events.ui.model.SportUi
import kotlinx.coroutines.launch

class SportsViewModel(
    private val getSportsUseCase: GetSportsUseCase
): ViewModel() {

    private val _sportsState: MutableState<ResponseStatus<MutableList<SportUi>>> = mutableStateOf(ResponseStatus.Loading)
    val sportsState: ResponseStatus<List<SportUi>>
        get() = _sportsState.value

    init {
        getSports()
    }

    fun addFavoriteSport(sport: SportUi) {
        _sportsState.value.let {
            if (it is ResponseStatus.Success) {

            }
        }
    }

    fun toggleIsCollapsed(sport: SportUi) {
        _sportsState.value.let { sportsState ->
            if (sportsState is ResponseStatus.Success) {
                sportsState.result.find {
                    it.sportId == sport.sportId
                }?.let { sport ->
                    sport.isCollapsed.value = !sport.isCollapsed.value
                }
            }
        }
    }

    private fun getSports() {
        viewModelScope.launch {
            getSportsUseCase.invoke().let { sportsResponse ->
                when(sportsResponse) {
                    is ResponseStatus.Success -> {
                        _sportsState.value = ResponseStatus.Success(
                            sportsResponse.result.map { it.toSportUi() }.toMutableList()
                        )
                    }
                    is ResponseStatus.Error -> {
                        _sportsState.value = sportsResponse
                    }
                    else -> {
                        _sportsState.value = ResponseStatus.Loading
                    }
                }
            }
        }
    }

}