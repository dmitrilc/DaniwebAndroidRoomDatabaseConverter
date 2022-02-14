package com.codelab.daniwebandroidroomdatabaseconverter

import androidx.room.BuiltInTypeConverters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Classroom::class], version = 1)
@TypeConverters(
    Converters::class
/*    builtInTypeConverters = BuiltInTypeConverters(
        enums = BuiltInTypeConverters.State.DISABLED
    )*/
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun classroomDao(): ClassroomDao
}