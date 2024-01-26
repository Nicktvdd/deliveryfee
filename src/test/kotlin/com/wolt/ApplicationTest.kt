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

	fun testTemplate(request: String, expectedResult: String, expectedStatusCode: HttpStatusCode) = testApplication {
		application {
			configureSerialization()
			configureRouting()
		}

		val response = client.post("/api/delivery-fee") {
			contentType(ContentType.Application.Json)
			setBody(request)
		}
		assertEquals(expectedResult, response.bodyAsText())
		assertEquals(expectedStatusCode, response.status)
	}

	@Test
	fun normalTest() = testApplication {
		testTemplate(
			"""{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""",
			"""{"delivery_fee":710}""",
			HttpStatusCode.OK
		)
	}

	@Test
	fun badCartValueTest() = testApplication {
		testTemplate(
			"""{"cart_value": -1, "delivery_distance": 2235, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""",
			"Invalid cart value",
			HttpStatusCode.BadRequest
		)
	}

	@Test
	fun badItemAmountTest() = testApplication {
		testTemplate(
			"""{"cart_value": 790, "delivery_distance": 2235, "number_of_items": 0, "time": "2024-01-15T13:00:00Z"}""",
			"Invalid amount of items",
			HttpStatusCode.BadRequest
		)
	}

	@Test
	fun badDistanceTest() = testApplication {
		testTemplate(
			"""{"cart_value": 790, "delivery_distance": -1, "number_of_items": 4, "time": "2024-01-15T13:00:00Z"}""",
			"Invalid distance",
			HttpStatusCode.BadRequest
		)
	}
	@Test
	fun gibberishTest() = testApplication {
		testTemplate(
			"""{"cart_value": 79ery_distance": -, "numbf_items": 4, "time": "20201-15T13:00:00Z"}""",
			"",
			HttpStatusCode.BadRequest
		)
	}
}
