package com.sd.productsfromdb_compose.data.repository

import com.sd.productsfromdb_compose.data.db.ProductDao
import com.sd.productsfromdb_compose.data.mapper.Mapper
import com.sd.productsfromdb_compose.domain.model.ProductModel
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {

    private val mapper = Mapper()

    override suspend fun getAllProducts() = productDao.getAllProducts().map {
        mapper.toModel(it)
    }

    override suspend fun changeAmount(productModel: ProductModel) {
        productDao.insert(mapper.toEntity(productModel))
    }

    override suspend fun deleteProduct(id: Int) {
        productDao.deleteProductById(id)
    }
}