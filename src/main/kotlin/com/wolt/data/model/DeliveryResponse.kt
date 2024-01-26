package com.wolt.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeliveryResponse(
	@SerialName("delivery_fee") val deliveryFee: Int
)
