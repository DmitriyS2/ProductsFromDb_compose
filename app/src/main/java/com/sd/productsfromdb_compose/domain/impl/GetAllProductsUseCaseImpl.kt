package com.sd.productsfromdb_compose.domain.impl

import androidx.lifecycle.LiveData
import com.sd.productsfromdb_compose.domain.api.GetAllProductsUseCase
import com.sd.productsfromdb_compose.domain.model.ProductModel
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : GetAllProductsUseCase {

    override operator fun invoke(): LiveData<List<ProductModel>> {
        return repository.getAllProducts()
    }
}