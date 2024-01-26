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
	fun testPostCustomer() = testApplication {
		application {
			configureSerialization()
			configureRouting() // Replace this with the actual configuration of your routes
		}

		val response = client.post("/api/delivery-fee") {
			contentType(ContentType.Application.Json)
			setBody("""{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""")
		}
		assertEquals("""{"deliveryFee":2}""", response.bodyAsText())
		assertEquals(HttpStatusCode.OK, response.status)
	}
}
