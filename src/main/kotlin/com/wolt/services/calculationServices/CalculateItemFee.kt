package com.wolt.services.calculationServices

fun calculateItemFee(numberOfItems: Int): Int {
	val baseAmountItems = 4
	val extraItemFee = 50
	val bulkItems = 12
	val bulkItemFee = 120

	return if (numberOfItems > baseAmountItems) {
		val extraItems = numberOfItems - baseAmountItems
		var itemFee = extraItems * extraItemFee
		if (numberOfItems > bulkItems) {
			itemFee += bulkItemFee
		}
		itemFee
	} else {
		0
	}
}