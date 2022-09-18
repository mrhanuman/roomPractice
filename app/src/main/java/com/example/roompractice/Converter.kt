package com.example.roompractice

import androidx.room.TypeConverter
import java.util.*

class Converter {

@TypeConverter
    fun dateToLong (value:Date):Long{
        return value.time
    }
@TypeConverter
    fun LongToDate (value:Long):Date{
        return Date(value)
    }
}