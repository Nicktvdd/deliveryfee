package com.wolt

import com.wolt.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
	@Test
	fun testApi() {
		val requestBody = """{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}"""

		val jsonData = jacksonObjectMapper().
		application {
			configureRouting()
		}
		client.post("/api/delivery-fee").apply {
			setBody(requestBody)
			assertEquals(HttpStatusCode.OK, status)
			assertEquals("application/json; charset=UTF-8", contentType().toString())
		}
	}
}
