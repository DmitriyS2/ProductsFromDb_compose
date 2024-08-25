package com.sd.productsfromdb_compose.domain.model

import java.util.Date

data class ProductModel(
    val id: Int = 0,
    val name: String = "Name",
    val time: Date = Date(),
    val tags: List<String> = listOf("First", "Second", "Third"),
    val amount: Int = 1,
)
