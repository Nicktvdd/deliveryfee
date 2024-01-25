package com.wolt.services

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.DayOfWeek

fun isItRush(request: String): Boolean {
	val formatter = DateTimeFormatter.ISO_DATE_TIME
	val dateTime = LocalDateTime.parse(request, formatter)

	return if (dateTime.dayOfWeek == DayOfWeek.FRIDAY) {
		val startOfRush = dateTime
			.withHour(15)
			.withMinute(0)
			.withSecond(0)
		val endOfRush = dateTime
			.withHour(19)
			.withMinute(0)
			.withSecond(0)
		return dateTime.isAfter(startOfRush) && dateTime.isBefore(endOfRush)
	} else {
		false
	}
}
