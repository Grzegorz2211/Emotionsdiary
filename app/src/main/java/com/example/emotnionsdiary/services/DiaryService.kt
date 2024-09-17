package com.example.emotnionsdiary.services

import android.content.Context
import com.example.emotnionsdiary.database.Diary
import com.example.emotnionsdiary.database.DiaryDatabaseHelper

class DiaryService(context: Context) {

    private val dbHelper = DiaryDatabaseHelper(context)

    fun saveDiary(title: String?, content: String?, emotion: String): String? {
        if (title.isNullOrBlank() || content.isNullOrBlank() || emotion.isBlank()) {
            return "Invalid input provided"
        }

        val diary = Diary(title = title, content = content, emotion = emotion)

        dbHelper.insertDiary(diary)

        return "Diary saved successfully"
    }

    fun getAllDiaries(): List<Diary> {
        return dbHelper.getAllDiaries()
    }

    fun deleteDiary(diaryId: Int) {
        dbHelper.deleteDiary(diaryId)
    }
}
