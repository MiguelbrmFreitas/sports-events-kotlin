package com.example.sports_events.ui.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.domain.core.ResponseStatus
import com.example.sports_events.R
import com.example.sports_events.ui.theme.DarkThemeColor
import com.example.sports_events.ui.theme.MainBlueColor
import com.example.sports_events.viewmodel.SportsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsScreen(
    sportsViewModel: SportsViewModel = koinViewModel()
) {
    val sportsState = sportsViewModel.sportsState

    val backgroundColor = if(isSystemInDarkTheme()) {
        DarkThemeColor
    } else {
        Color.LightGray
    }

    Surface(
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_title)) },
                colors = topAppBarColors(
                    containerColor = MainBlueColor,
                    titleContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

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
                        },
                        filterFavoriteEventsBySport = {
                            sportsViewModel.filterFavoriteEventsBySport(it)
                        }
                    )
                }
                is ResponseStatus.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
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