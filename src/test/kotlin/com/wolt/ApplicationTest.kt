package com.wolt

import com.wolt.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
	@Test
	fun testRoot() = testApplication {
		val requestBody = """{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}"""

		application {
			configureRouting()
		}
		client.post("/delivery-fee").apply {
			assertEquals(HttpStatusCode.OK, status)
			assertEquals("application/json; charset=UTF-8", contentType().toString())
		}
	}
}
