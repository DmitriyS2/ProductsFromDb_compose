package com.sd.productsfromdb_compose.data.mapper

import com.sd.productsfromdb_compose.data.db.ProductEntity
import com.sd.productsfromdb_compose.domain.model.ProductModel


class Mapper {

    fun toEntity(productModel: ProductModel):ProductEntity {
        return ProductEntity(
            id = productModel.id,
            name = productModel.name,
            time = productModel.time,
            tags = productModel.tags,
            amount = productModel.amount
        )
    }

    fun toModel(productEntity: ProductEntity):ProductModel {
        return ProductModel(
            id = productEntity.id,
            name = productEntity.name,
            time = productEntity.time,
            tags = productEntity.tags,
            amount = productEntity.amount
        )
    }
}

