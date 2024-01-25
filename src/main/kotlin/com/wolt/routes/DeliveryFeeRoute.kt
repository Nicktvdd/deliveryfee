package com.wolt.routes

import com.wolt.data.model.DeliveryRequest
import com.wolt.data.model.DeliveryResponse
import com.wolt.services.calculateDeliveryFee
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://localhost:8080" //make this dynamic somehow?

fun Route.deliveryFee() {
	route("/api/delivery-fee") {
		post {
			val request = call.receive<DeliveryRequest>()
			val deliveryFee = calculateDeliveryFee(request)
			call.respond(DeliveryResponse(deliveryFee))
		}
	}
}
