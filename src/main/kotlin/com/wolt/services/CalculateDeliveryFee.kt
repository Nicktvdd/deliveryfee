package com.wolt.services

import com.wolt.data.model.DeliveryRequest
import kotlin.math.floor

fun calculateDeliveryFee(request: DeliveryRequest): Int {
	if (request.cartValue > 20000) {
		return 0
	}
	var calculatedFee = 2
	val minimumOrderFee = calculateMinimumOrderFee(request.cartValue)
	val distanceFee = calculateDistanceFee(request.deliveryDistance)
	val itemFee = calculateItemFee(request.numberOfItems)

	if (isItRush(request.time)) {
		calculatedFee *= 1.2.toInt()
	}

	calculatedFee += (minimumOrderFee + distanceFee + itemFee)
	if (calculatedFee > 15) {
		calculatedFee = 15
	}

	return calculatedFee
}

fun calculateMinimumOrderFee(cartValue: Int): Int {
	return if (cartValue < 1000) {
		1000 - cartValue
	} else {
		0
	}
}

fun calculateDistanceFee(deliveryDistance: Int): Int {
	return if (deliveryDistance > 1000) {
		val extraDistance = deliveryDistance - 1000
		val distanceIn500s = extraDistance / 500
		val roundedDown = floor(distanceIn500s.toDouble()).toInt()
		roundedDown * 100
	} else {
		0
	}
}

fun calculateItemFee(numberOfItems: Int): Int {
	return if (numberOfItems >= 5) {
		val extraItems = numberOfItems - 4
		var itemFee = extraItems * 50
		if (numberOfItems > 12) {
			itemFee += 120
		}
		itemFee
	} else {
		0
	}
}
