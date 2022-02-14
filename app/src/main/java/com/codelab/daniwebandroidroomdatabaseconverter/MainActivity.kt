package com.codelab.daniwebandroidroomdatabaseconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            SchoolDatabase::class.java, "school-db"
        ).build()

        lifecycleScope.launch(Dispatchers.IO) {
            val classroomDao = db.classroomDao()

            val teacher1 = Teacher(
                name = "Mary",
                age = 35
            )

            val teacher2 = Teacher(
                name = "John",
                age = 28
            )

            val teacher3 = Teacher(
                name = "Diana",
                age = 46
            )

            val classroom1 = Classroom(
                grade = Grade.JUNIOR,
                homeroomTeacher = teacher1
            )

            val classroom2 = Classroom(
                grade = Grade.SOPHOMORE,
                homeroomTeacher = teacher2
            )

            val classroom3 = Classroom(
                grade = Grade.SENIOR,
                homeroomTeacher = teacher3
            )

            classroomDao.insertAll(
                classroom1,
                classroom2,
                classroom3
            )

            val classrooms = classroomDao.getAll()

            classrooms.forEach {
                Log.d(TAG, "$it")
            }

            db.clearAllTables()
        }

    }
}