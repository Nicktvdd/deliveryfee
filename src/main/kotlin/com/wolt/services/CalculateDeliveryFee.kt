package com.wolt.services

import com.wolt.data.model.DeliveryRequest
import com.wolt.services.calculationServices.calculateDistanceFee
import com.wolt.services.calculationServices.calculateItemFee
import com.wolt.services.calculationServices.calculateMinimumOrderFee
import com.wolt.services.calculationServices.isItRush

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


