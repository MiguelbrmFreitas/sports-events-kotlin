package com.example.sports_events.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Event
import com.example.domain.model.FavoriteEvent
import com.example.domain.usecase.AddFavoriteEventUseCase
import com.example.domain.usecase.GetFavoriteEventsUseCase
import com.example.domain.usecase.GetSportsUseCase
import com.example.domain.usecase.RemoveFavoriteEventUseCase
import com.example.sports_events.helper.ext.toSportUi
import com.example.sports_events.helper.ext.toStringTime
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SportsViewModel(
    private val getSportsUseCase: GetSportsUseCase,
    private val getFavoriteEventsUseCase: GetFavoriteEventsUseCase,
    private val addFavoriteEventUseCase: AddFavoriteEventUseCase,
    private val removeFavoriteEventUseCase: RemoveFavoriteEventUseCase
): ViewModel() {

    private val _sportsState: MutableState<ResponseStatus<List<SportUi>>> = mutableStateOf(ResponseStatus.Loading)
    val sportsState: ResponseStatus<List<SportUi>>
        get() = _sportsState.value

    private val favoriteEvents: MutableList<FavoriteEvent> = mutableListOf()

    init {
        getSports()
        getFavoriteEvents()
    }

    fun toggleFavoriteEvent(event: EventUi) {
        event.isFavorite.value = !event.isFavorite.value
        if (event.isFavorite.value) {
            addFavoriteEvent(event)
        } else {
            removeFavoriteEvent(event)
        }
    }

    fun toggleIsCollapsed(sport: SportUi) {
        sport.isCollapsed.value = !sport.isCollapsed.value
        if (!sport.isCollapsed.value) {
            updateSportListWithFavoriteEvents(sport)
        }
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

    fun onSportClicked(sport: SportUi) {
        updateSportListWithFavoriteEvents(sport)
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

    private fun getFavoriteEvents() {
        viewModelScope.launch {
            getFavoriteEventsUseCase.invoke().let { favoriteEventsList ->
                favoriteEvents.addAll(favoriteEventsList)
            }
        }
    }

    private fun addFavoriteEvent(event: EventUi) {
        viewModelScope.launch {
            addFavoriteEventUseCase.invoke(
                FavoriteEvent(
                    eventId = event.eventId,
                    sportId = event.sportId
                )
            )
        }
    }

    private fun removeFavoriteEvent(event: EventUi) {
        viewModelScope.launch {
            removeFavoriteEventUseCase.invoke(
                FavoriteEvent(
                    eventId = event.eventId,
                    sportId = event.sportId
                )
            )
        }
    }

    private fun updateSportListWithFavoriteEvents(sport: SportUi) {
        if (favoriteEvents.any { it.sportId == sport.sportId }) {
            sport.events.forEach { event ->
                if (favoriteEvents.any { it.eventId == event.eventId }) {
                    event.isFavorite.value = true
                }
            }
        }
    }

}