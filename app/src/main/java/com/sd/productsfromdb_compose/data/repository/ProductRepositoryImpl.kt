package com.sd.productsfromdb_compose.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.sd.productsfromdb_compose.data.db.ProductDao
import com.sd.productsfromdb_compose.data.db.ProductEntity
import com.sd.productsfromdb_compose.data.mapper.Mapper
import com.sd.productsfromdb_compose.domain.model.ProductModel
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import java.util.Date
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {

    private val mapper = Mapper()

    override fun getAllProducts(): LiveData<List<ProductModel>> {
        return productDao.getAllProducts().map { listEntity ->
            listEntity.map { entity ->
                mapper.toModel(entity)
            }
        }
    }

    override suspend fun changeAmount(productModel: ProductModel) {
        productDao.insert(mapper.toEntity(productModel))
    }

    override suspend fun deleteProduct(id: Int) {
        productDao.deleteProductById(id)
    }

    override suspend fun addNewProduct(name: String, date: Date, tags: List<String>, stock: Int) {
        val temp = ProductEntity(
            id = 0,
            name = name,
            time = date,
            tags = tags,
            amount = stock,
        )
        productDao.insert(temp)
    }
}