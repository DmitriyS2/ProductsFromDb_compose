package com.sd.productsfromdb_compose.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "item")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "time")
    val time: Date,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "amount")
    val amount: Int,
)
