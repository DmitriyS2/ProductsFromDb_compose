package com.sd.productsfromdb_compose.domain.api

import com.sd.productsfromdb_compose.domain.model.ProductModel

interface GetAllProductsUseCase {

    suspend operator fun invoke(): List<ProductModel>
}