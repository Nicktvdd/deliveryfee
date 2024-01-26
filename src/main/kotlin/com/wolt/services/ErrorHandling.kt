package com.wolt.services

import com.wolt.data.model.DeliveryRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend fun errorHandling(call: ApplicationCall, request: DeliveryRequest) {
	if (request.cartValue < 0)
		call.respond(HttpStatusCode.BadRequest, "Invalid cart value")
}
