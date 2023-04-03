package tech.developingdeveloper.springbootfileupload.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by Abhishek Saxena on 12-11-2021.
 */

fun getCurrentTimestamp(pattern: String? = null, dateTimeFormatter: DateTimeFormatter? = null): String {
    val timestamp = LocalDateTime.now()
    if ((pattern == null) and (dateTimeFormatter == null)) return timestamp.toString()
    val formatter = dateTimeFormatter ?: DateTimeFormatter.ofPattern(pattern)
    return formatter.format(timestamp)
}
