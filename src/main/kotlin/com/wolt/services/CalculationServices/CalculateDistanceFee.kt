package com.wolt.services.CalculationServices

import kotlin.math.ceil

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