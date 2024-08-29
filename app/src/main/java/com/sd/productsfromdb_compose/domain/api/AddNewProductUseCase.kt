package com.sd.productsfromdb_compose.domain.api

interface AddNewProductUseCase {

    suspend operator fun invoke(name: String, chips: String, stock: String)
}