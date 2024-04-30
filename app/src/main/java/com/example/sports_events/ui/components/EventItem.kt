package com.example.sports_events.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Event
import com.example.sports_events.R

@Composable
fun EventItem(event: Event) {
    Column(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = "countdown timer", // change later to actual timer
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 16.sp
        )
        Image(
            painter = painterResource(id = R.drawable.star_empty),
            contentDescription = stringResource(id = R.string.content_description_star),
            modifier = Modifier.padding(top = 4.dp),
        )
        Text(
            text = event.firstCompetitor,
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 14.sp
        )
        Text(
            text = stringResource(id = R.string.versus),
            color = Color.Red,
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 14.sp
        )
        Text(
            text = event.secondCompetitor,
            modifier = Modifier.padding(top = 4.dp),
            fontSize = 14.sp
        )
    }
}