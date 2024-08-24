package com.sd.productsfromdb_compose.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProductEntity(
    @PrimaryKey
    val id:Int,
)
