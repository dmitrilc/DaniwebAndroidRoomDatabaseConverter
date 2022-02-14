package com.codelab.daniwebandroidroomdatabaseconverter

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun teacherToString(teacher: Teacher) = "$teacher" //Other options are json string, serialized blob

    @TypeConverter
    fun stringToTeacher(value: String): Teacher {
        val name = value.substringBefore(':')
        val age = value.substringAfter(':').toInt()

        return Teacher(name, age)
    }

}