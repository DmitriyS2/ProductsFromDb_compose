package com.sd.productsfromdb_compose.domain.repository

import androidx.lifecycle.LiveData
import com.sd.productsfromdb_compose.domain.model.ProductModel

interface ProductRepository {

    fun getAllProducts(): LiveData<List<ProductModel>>
    suspend fun changeAmount(productModel: ProductModel)
    suspend fun deleteProduct(id: Int)
}