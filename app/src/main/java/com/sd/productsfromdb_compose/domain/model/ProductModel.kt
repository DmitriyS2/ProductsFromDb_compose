package com.sd.productsfromdb_compose.domain.model

import java.util.Date

data class ProductModel(
    val id: Int = 0,
    val name: String = "",
    val time: Date = Date(),
    val tags: List<String> = emptyList(),
    val amount: Int = 0,
)
