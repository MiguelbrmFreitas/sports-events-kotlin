package com.example.sports_events.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Sport

@Composable
fun SportsScreen(
    responseStatus: ResponseStatus<List<Sport>>
) {
    when(responseStatus) {
        is ResponseStatus.Success -> {

        }
        is ResponseStatus.Loading -> {

        }
        is ResponseStatus.Error -> {

        }
    }
}