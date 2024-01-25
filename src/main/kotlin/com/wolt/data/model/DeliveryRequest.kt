package com.wolt.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class DeliveryRequest(
	@SerialName("cart_value") val cartValue: Int,
	@SerialName("delivery_distance") val deliveryDistance: Int,
	@SerialName("number_of_items") val numberOfItems: Int,
	val time: String
)
