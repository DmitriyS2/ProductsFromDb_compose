package com.sd.productsfromdb_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sd.productsfromdb_compose.data.db.converter.DateConverter
import com.sd.productsfromdb_compose.data.db.converter.ListConverter


@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, ListConverter::class)
abstract class AppDb : RoomDatabase() {

    abstract fun productDao(): ProductDao
}