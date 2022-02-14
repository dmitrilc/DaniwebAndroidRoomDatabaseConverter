package com.codelab.daniwebandroidroomdatabaseconverter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Classroom(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val grade: Grade,
    @ColumnInfo(name = "homeroom_teacher") val homeroomTeacher: Teacher
)