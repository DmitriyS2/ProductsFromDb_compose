package com.sd.productsfromdb_compose.domain.impl

import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : GetAllProductsUseCase {

    override suspend operator fun invoke(): List<ProductModel> {
        return repository.getAllProducts()
    }
}