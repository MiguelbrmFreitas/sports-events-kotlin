package com.example.sports_events

import com.example.sports_events.helper.TestHelper
import com.example.sports_events.helper.ext.filterFavoriteEvents
import org.junit.Test

class SportUiExtTest {

    @Test
    fun `given a sportUi model, it should filter the favorite events when showFavorite is true`() {
        // Given
        val sport = TestHelper.sportMock
        val expected = TestHelper.eventsAfterFilteringMock

        // When
        val resultList = sport.filterFavoriteEvents()

        // Then
        resultList.forEachIndexed { index, resultEvent ->
            assert(expected.get(index).isFavorite.value == resultEvent.isFavorite.value)
            assert(expected.get(index).eventId == resultEvent.eventId)
            assert(expected.get(index).sportId == resultEvent.sportId)
            assert(expected.get(index).firstCompetitor == resultEvent.firstCompetitor)
            assert(expected.get(index).secondCompetitor == resultEvent.secondCompetitor)
            assert(expected.get(index).formattedTime.value == resultEvent.formattedTime.value)
            assert(expected.get(index).timestamp == resultEvent.timestamp)
        }
    }

}