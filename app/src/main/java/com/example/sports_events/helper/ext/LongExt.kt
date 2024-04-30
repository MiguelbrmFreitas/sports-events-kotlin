package com.example.sports_events.helper.ext

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
fun Long.toStringTime(): String {
    val timestampMillis = this * 1000L

    val currentTime = System.currentTimeMillis()
    val difference = timestampMillis - currentTime

    if (difference <= 0L) {
        return "00d:00h:00m:00s"
    }

    val days = (difference / (1000 * 60 * 60 * 24)).toInt()
    val hours = ((difference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)).toInt()
    val minutes = ((difference % (1000 * 60 * 60)) / (1000 * 60)).toInt()
    val seconds = ((difference % (1000 * 60)) / 1000).toInt()

//    val formattedString = String.format("%03d:%02d:%02d:%02d", days, hours, minutes, seconds)
//    val formattedString = "$days:$hours:$minutes:$seconds"

    return String.format("%02dd:%02dh:%02dm:%02ds", days, hours, minutes, seconds)
}