package com.sd.productsfromdb_compose.domain.impl

import com.sd.productsfromdb_compose.domain.api.DeleteProductUseCase
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import javax.inject.Inject

class DeleteProductUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
):DeleteProductUseCase {

    override suspend operator fun invoke(id:Int) {
        repository.deleteProduct(id)
    }
}