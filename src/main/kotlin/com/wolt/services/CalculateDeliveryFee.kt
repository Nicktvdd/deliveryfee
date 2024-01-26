package com.wolt.services

import com.wolt.data.model.DeliveryRequest
import kotlin.math.ceil

fun calculateDeliveryFee(request: DeliveryRequest): Int {
	val freeDelivery = 20000
	val rushMultiplier = 1.2
	val maxDeliveryFee = 1500
	var calculatedFee = 0

	if (request.cartValue > freeDelivery) {
		return 0
	}
	val minimumOrderFee = calculateMinimumOrderFee(request.cartValue)
	val distanceFee = calculateDistanceFee(request.deliveryDistance)
	val itemFee = calculateItemFee(request.numberOfItems)

	calculatedFee += (minimumOrderFee + distanceFee + itemFee)

	if (isItRush(request.time)) {
		calculatedFee = (calculatedFee * rushMultiplier).toInt()
	}


	if (calculatedFee > maxDeliveryFee) {
		calculatedFee = maxDeliveryFee
	}

	return calculatedFee
}

fun calculateMinimumOrderFee(cartValue: Int): Int {
	val minimumCartValue = 1000

	return if (cartValue < minimumCartValue) {
		minimumCartValue - cartValue
	} else {
		0
	}
}

fun calculateDistanceFee(deliveryDistance: Int): Int {
	val baseDeliveryDistance = 1000
	val baseFee = 200
	var fee = baseFee
	val additionalDistance = maxOf(0, deliveryDistance - baseDeliveryDistance)

	if (additionalDistance > 0) {
		val additionalFee = (ceil(additionalDistance.toDouble() / 500).toInt()) * 100
		fee += additionalFee
	}

	// The minimum fee is always 1€
	return maxOf(100, fee)
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
