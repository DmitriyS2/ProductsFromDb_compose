package com.sd.productsfromdb_compose.data.db.converter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListConverter {

    @TypeConverter
    fun toList(data: String): List<String> {
        return Json.decodeFromString(data)
    }

    @TypeConverter
    fun fromList(list: List<String?>): String {
        return Json.encodeToString(list)
    }
}