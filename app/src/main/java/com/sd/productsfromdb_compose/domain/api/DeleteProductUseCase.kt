package com.sd.productsfromdb_compose.domain.api

interface DeleteProductUseCase {

    suspend operator fun invoke(id:Int)
}