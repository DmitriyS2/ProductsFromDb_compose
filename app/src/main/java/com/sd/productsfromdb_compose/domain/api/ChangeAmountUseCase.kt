package com.sd.productsfromdb_compose.domain.api

import com.sd.productsfromdb_compose.domain.model.ProductModel

interface ChangeAmountUseCase {

    suspend operator fun invoke(productModel: ProductModel)
}