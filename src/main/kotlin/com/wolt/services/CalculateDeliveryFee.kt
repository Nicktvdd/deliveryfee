package com.wolt.services

import com.wolt.data.model.DeliveryRequest
import kotlin.math.floor

fun calculateDeliveryFee(request: DeliveryRequest): Int {
	var calculatedFee: Int = 2

	// separate into functions!!
	if (request.cartValue > 20000) {
		return 0
	}

	if (request.cartValue < 10) {
		val minimumOrderFee =  10 - request.cartValue
	}

	if (request.deliveryDistance > 1000) {
		val extraDistance = request.deliveryDistance - 1000
		val distanceIn500s = extraDistance / 500
		val roundedDown = floor(distanceIn500s.toDouble()).toInt()
		val distanceFee = calculatedFee + (roundedDown * 100)
	}

	if (request.numberOfItems >= 5) {
		val extraItems = request.numberOfItems - 4
		var itemFee = extraItems * 50
		if (request.numberOfItems > 12) {
			itemFee += 120
		}
	}

	if (isItRush(request.time)) {
		calculatedFee *= 1.2.toInt()
	}
	//calculatedFee += (minimumOrderFee + distanceFee + itemFee)

	if (calculatedFee > 15){
		calculatedFee = 15
		return calculatedFee
	}
	return calculatedFee
}