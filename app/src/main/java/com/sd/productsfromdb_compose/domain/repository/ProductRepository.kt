package com.sd.productsfromdb_compose.domain.repository

import com.sd.productsfromdb_compose.domain.model.ProductModel

interface ProductRepository {

   suspend fun getAllProducts():List<ProductModel>
}