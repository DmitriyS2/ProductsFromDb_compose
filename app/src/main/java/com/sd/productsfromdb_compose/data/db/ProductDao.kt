package com.sd.productsfromdb_compose.data.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProductDao {

    //дать products из БД
    @Query("SELECT * FROM item")
    fun getProducts(): List<ProductEntity>
}