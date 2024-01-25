package com.wolt.plugins

import com.wolt.routes.deliveryFee
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		get("/") {
			call.respondText("Hi, use /api/delivery-fee")
		}
		deliveryFee()
	}
}
