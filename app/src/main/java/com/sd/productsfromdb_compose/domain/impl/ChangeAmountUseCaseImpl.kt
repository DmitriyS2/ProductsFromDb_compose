package com.sd.productsfromdb_compose.domain.impl

import com.sd.productsfromdb_compose.domain.api.ChangeAmountUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import javax.inject.Inject

class ChangeAmountUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : ChangeAmountUseCase {

    override suspend operator fun invoke(productModel: ProductModel) {
        repository.changeAmount(productModel)
    }
}