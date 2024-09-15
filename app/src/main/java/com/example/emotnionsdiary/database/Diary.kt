package com.example.emotnionsdiary.database

data class Diary(
    val id: Int = 0,
    val title: String,
    val content: String,
    val emotion: String
)
