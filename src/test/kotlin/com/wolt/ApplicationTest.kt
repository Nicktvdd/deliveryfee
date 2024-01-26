package com.wolt

import com.wolt.plugins.configureRouting
import com.wolt.plugins.configureSerialization
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerTests {
	@Test
	fun testNormal() = testApplication {
		application {
			configureSerialization()
			configureRouting() // Replace this with the actual configuration of your routes
		}

		val response = client.post("/api/delivery-fee") {
			contentType(ContentType.Application.Json)
			setBody("""{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""")
		}
		assertEquals("""{"deliveryFee":15}""", response.bodyAsText())
		assertEquals(HttpStatusCode.OK, response.status)
	}
	@Test
	fun testBadCartValue() = testApplication {
		application {
			configureSerialization()
			configureRouting() // Replace this with the actual configuration of your routes
		}

		val response = client.post("/api/delivery-fee") {
			contentType(ContentType.Application.Json)
			setBody("""{"cart_value": -1, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""")
		}
		assertEquals("Invalid cart value", response.bodyAsText())
		assertEquals(HttpStatusCode.BadRequest, response.status)
	}	@Test
	fun testBadItemAmount() = testApplication {
		application {
			configureSerialization()
			configureRouting() // Replace this with the actual configuration of your routes
		}

		val response = client.post("/api/delivery-fee") {
			contentType(ContentType.Application.Json)
			setBody("""{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 0, "time": "2024-01-15T13:00:00Z"}""")
		}
		assertEquals("Invalid amount of items", response.bodyAsText())
		assertEquals(HttpStatusCode.BadRequest, response.status)
	}
}
