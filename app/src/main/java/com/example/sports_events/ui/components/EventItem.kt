package com.example.sports_events.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Event
import com.example.sports_events.R
import com.example.sports_events.helper.ext.toStringTime
import com.example.sports_events.ui.model.EventUi
import com.example.sports_events.ui.theme.MainRedColor
import kotlinx.coroutines.launch

@Composable
fun EventItem(
    event: EventUi,
    onToggleFavoriteChanged: (EventUi) -> Unit,
    onStartCountDownTimer: (EventUi) -> Unit
) {
    Column(
        modifier = Modifier
            .sizeIn(
                minWidth = 120.dp
            )
    ) {
        onStartCountDownTimer(event)
        Text(
            text = event.formattedTime.value,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        val starDrawable = if(event.isFavorite.value) {
            R.drawable.star_filled
        } else {
            if (isSystemInDarkTheme()) {
                R.drawable.star_empty_white
            } else {
                R.drawable.star_empty
            }
        }

        Image(
            painter = painterResource(id = starDrawable),
            contentDescription = stringResource(id = R.string.content_description_star),
            modifier = Modifier
                .padding(top = 2.dp)
                .size(20.dp)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    onToggleFavoriteChanged(event)
                }
        )
        Text(
            text = event.firstCompetitor,
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.versus),
            color = MainRedColor,
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = event.secondCompetitor,
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}