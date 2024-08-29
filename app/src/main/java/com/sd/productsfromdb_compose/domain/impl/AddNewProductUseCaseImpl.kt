package com.sd.productsfromdb_compose.domain.impl

import com.sd.productsfromdb_compose.domain.api.AddNewProductUseCase
import com.sd.productsfromdb_compose.domain.repository.ProductRepository
import java.util.Date
import javax.inject.Inject

class AddNewProductUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
) : AddNewProductUseCase {

    override suspend fun invoke(name: String, chips: String, stock: String) {
        val tags: List<String> = if (chips.isEmpty()) emptyList() else chips.split(",").toList()
        val date = Date()
        val amount = stock.toInt()
        repository.addNewProduct(name, date, tags, amount)
    }
}