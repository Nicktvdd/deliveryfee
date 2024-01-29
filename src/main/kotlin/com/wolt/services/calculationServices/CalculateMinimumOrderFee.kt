package com.wolt.services.calculationServices

fun calculateMinimumOrderFee(cartValue: Int): Int {
	val minimumCartValue = 1000

	return if (cartValue < minimumCartValue) {
		minimumCartValue - cartValue
	} else {
		0
	}
}