package com.sd.productsfromdb_compose.domain.repository

import androidx.lifecycle.LiveData
import com.sd.productsfromdb_compose.domain.model.ProductModel
import java.util.Date

interface ProductRepository {

    fun getAllProducts(): LiveData<List<ProductModel>>
    suspend fun changeAmount(productModel: ProductModel)
    suspend fun deleteProduct(id: Int)
    suspend fun addNewProduct(name: String, date: Date, tags: List<String>, stock: Int)
}