package com.example.sports_events.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.core.ResponseStatus
import com.example.sports_events.R
import com.example.sports_events.viewmodel.SportsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SportsScreen(
    sportsViewModel: SportsViewModel = koinViewModel()
) {
    val sportsState = sportsViewModel.sportsState
    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            when(sportsState) {
                is ResponseStatus.Success -> {
                    SportsList(
                        sports = sportsState.result,
                        onToggleCollapsed = {
                            sportsViewModel.toggleIsCollapsed(it)
                        },
                        onToggleFavorite = {
                            sportsViewModel.toggleFavoriteEvent(it)
                        },
                        onToggleShowFavoriteEvents = {
                            sportsViewModel.toggleShowFavoriteEvents(it)
                        },
                        onStartCountDownTimer = {
                            sportsViewModel.startCountDownTimer(it)
                        }
                    )
                }
                is ResponseStatus.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                is ResponseStatus.Error -> {
                    Text(
                        text = stringResource(id = R.string.error_api),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}