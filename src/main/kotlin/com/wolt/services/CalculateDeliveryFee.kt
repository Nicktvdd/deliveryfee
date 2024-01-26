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

	return fee
}


fun calculateItemFee(numberOfItems: Int): Int {
	val baseAmountItems = 4
	val extraItemFee = 50
	val bulkItems = 12
	val bulkItemFee = 120

	return if (numberOfItems > baseAmountItems) {
		val extraItems = numberOfItems - baseAmountItems
		var itemFee = extraItems * extraItemFee
		if (numberOfItems > bulkItems) {
			itemFee += bulkItemFee
		}
		itemFee
	} else {
		0
	}
}
