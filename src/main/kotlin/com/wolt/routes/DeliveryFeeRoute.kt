package com.wolt.routes

import com.wolt.data.model.DeliveryRequest
import com.wolt.data.model.DeliveryResponse
import com.wolt.services.calculateDeliveryFee
import com.wolt.services.errorHandling
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deliveryFee() {
	route("/api/delivery-fee") {
		post {
			val request = call.receive<DeliveryRequest>()
			errorHandling(call, request)
			val deliveryFee = calculateDeliveryFee(request)
			call.respond(DeliveryResponse(deliveryFee))
		}
	}
}
