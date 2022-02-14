package com.codelab.daniwebandroidroomdatabaseconverter

data class Teacher(
    val name: String,
    val age: Int
) {
    override fun toString(): String {
        return "$name:$age"
    }
}