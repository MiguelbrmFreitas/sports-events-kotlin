package com.example.sports_events.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.core.ResponseStatus
import com.example.domain.model.Sport

@Composable
fun SportsScreen(
    responseStatus: ResponseStatus<List<Sport>>
) {
    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(16.dp)
        ) {
            when(responseStatus) {
                is ResponseStatus.Success -> {
                    SportsList(sports = responseStatus.result)
                }
                is ResponseStatus.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                is ResponseStatus.Error -> {

                }
            }
        }
    }
}