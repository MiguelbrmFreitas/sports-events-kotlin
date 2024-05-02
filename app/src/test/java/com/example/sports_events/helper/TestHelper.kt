package com.example.sports_events.helper

import androidx.compose.runtime.mutableStateOf
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.model.SportUi

object TestHelper {

    val eventsBeforeFilteringMock = listOf(
        EventUi(
            eventId = "1",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(false)
        ),
        EventUi(
            eventId = "2",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(true)
        ),
        EventUi(
            eventId = "3",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(true)
        ),
        EventUi(
            eventId = "4",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(false)
        ),
        EventUi(
            eventId = "5",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(false)
        ),
    )

    val eventsAfterFilteringMock = listOf(
        EventUi(
            eventId = "2",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(true)
        ),
        EventUi(
            eventId = "3",
            sportId = "FOOT",
            firstCompetitor = "Moss FK",
            secondCompetitor = "Viking FK",
            timestamp = 1714345560L,
            isFavorite = mutableStateOf(true)
        )
    )

    val sportMock = SportUi(
        sportId = "FOOT",
        sportName = "SOCCER",
        events = eventsBeforeFilteringMock,
        showFavorite = mutableStateOf(true)
    )
}