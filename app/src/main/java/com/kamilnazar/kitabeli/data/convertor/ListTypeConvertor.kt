package com.kamilnazar.kitabeli.data.convertor

import androidx.room.TypeConverter
import com.kamilnazar.kitabeli.data.db.AppDb
import com.squareup.moshi.Types

class ListTypeConvertor {
    companion object {
        @JvmStatic
        private val intList =
            Types.newParameterizedType(List::class.java, Int::class.javaObjectType)
        @JvmStatic
        private val stringList = Types.newParameterizedType(List::class.java, String::class.java)
        @JvmStatic
        private val intListAdapter = AppDb.moshi.adapter<List<Int>>(intList)
        @JvmStatic
        private val stringListAdapter = AppDb.moshi.adapter<List<String>>(stringList)

        @JvmStatic
        @TypeConverter
        fun toJson(list: List<Int>): String {
            return intListAdapter.toJson(list)
        }

        @JvmStatic
        @TypeConverter
        fun fromJson(string: String): List<Int>? {
            return intListAdapter.fromJson(string)
        }

        @JvmStatic
        @TypeConverter
        fun toJsonS(list: List<String>): String {
            return stringListAdapter.toJson(list)
        }

        @JvmStatic
        @TypeConverter
        fun fromJsonS(string: String): List<String>? {
            return stringListAdapter.fromJson(string)
        }

    }
}