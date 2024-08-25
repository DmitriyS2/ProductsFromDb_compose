package com.sd.productsfromdb_compose.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    //дать products из БД
    @Query("SELECT * FROM item")
    fun getAllProducts(): List<ProductEntity>

    // вставить/поменять product в БД
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)

    //удалить product из БД
    @Query("DELETE FROM item WHERE id = :id")
    suspend fun deleteProductById(id: Int)
}