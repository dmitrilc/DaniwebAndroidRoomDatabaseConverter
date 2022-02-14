package com.codelab.daniwebandroidroomdatabaseconverter

import androidx.room.*

@Dao
interface ClassroomDao {
    @Query("SELECT * FROM classroom")
    fun getAll(): List<Classroom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg classrooms: Classroom)
}