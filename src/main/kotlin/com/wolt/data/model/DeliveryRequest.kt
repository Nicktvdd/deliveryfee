package com.wolt.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryRequest(
	val cartValue: Int,
	val deliveryDistance: Int,
	val numberOfItems: Int,
	val time: String
)
