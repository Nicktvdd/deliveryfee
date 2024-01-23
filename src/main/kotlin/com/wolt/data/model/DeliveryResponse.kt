package com.wolt.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryResponse(
	val deliveryFee: Int
)
