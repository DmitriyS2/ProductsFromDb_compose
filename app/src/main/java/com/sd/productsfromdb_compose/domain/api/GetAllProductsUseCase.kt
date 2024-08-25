package com.sd.productsfromdb_compose.domain.api

import androidx.lifecycle.LiveData
import com.sd.productsfromdb_compose.domain.model.ProductModel

interface GetAllProductsUseCase {

    operator fun invoke(): LiveData<List<ProductModel>>
}