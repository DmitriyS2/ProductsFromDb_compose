package com.sd.productsfromdb_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {

    abstract fun productDao(): ProductDao
}