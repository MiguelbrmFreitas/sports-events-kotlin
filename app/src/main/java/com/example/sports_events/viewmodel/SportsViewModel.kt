package com.example.sports_events.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Event
import com.example.domain.usecase.GetSportsUseCase
import com.example.sports_events.helper.ext.toSportUi
import com.example.sports_events.helper.ext.toStringTime
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SportsViewModel(
    private val getSportsUseCase: GetSportsUseCase
): ViewModel() {

    private val _sportsState: MutableState<ResponseStatus<List<SportUi>>> = mutableStateOf(ResponseStatus.Loading)
    val sportsState: ResponseStatus<List<SportUi>>
        get() = _sportsState.value

    init {
        getSports()
    }

    fun toggleFavoriteEvent(event: EventUi) {
        event.isFavorite.value = !event.isFavorite.value
    }

    fun toggleIsCollapsed(sport: SportUi) {
        sport.isCollapsed.value = !sport.isCollapsed.value
    }

    fun toggleShowFavoriteEvents(sport: SportUi) {
        sport.showFavorite.value = !sport.showFavorite.value
    }

    fun startCountDownTimer(event: EventUi) {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                event.formattedTime.value = event.timestamp.toStringTime()
            }
        }
    }

    private fun getSports() {
        viewModelScope.launch {
            getSportsUseCase.invoke().let { sportsResponse ->
                when(sportsResponse) {
                    is ResponseStatus.Success -> {
                        _sportsState.value = ResponseStatus.Success(
                            sportsResponse.result.map { it.toSportUi() }
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