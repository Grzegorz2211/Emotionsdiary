package com.example.emotnionsdiary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.test.core.app.ApplicationProvider
import com.example.emotnionsdiary.database.Diary
import com.example.emotnionsdiary.database.DiaryDatabaseHelper
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DiaryDatabaseHelperTest {

    private lateinit var dbHelper: DiaryDatabaseHelper
    private lateinit var db: SQLiteDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        dbHelper = DiaryDatabaseHelper(context )
        db = dbHelper.writableDatabase
        clearDatabase()
    }

    private fun clearDatabase() {
        db.execSQL("DELETE FROM ${DiaryDatabaseHelper.TABLE_NAME}")
    }

    @After
    fun tearDown() {
        dbHelper.close()
    }

    @Test
    fun testInsertDiary() {
        val diary = Diary(1, "Test Title", "Test Content", "Happy")
        dbHelper.insertDiary(diary)

        val diaries = dbHelper.getAllDiaries()
        assertEquals(1, diaries.size)

        val retrievedDiary = diaries[0]
        assertEquals(diary.title, retrievedDiary.title)
        assertEquals(diary.content, retrievedDiary.content)
        assertEquals(diary.emotion, retrievedDiary.emotion)
    }

    @Test
    fun testGetAllDiaries() {
        val diary1 = Diary(1, "Test Title 1", "Test Content 1", "Happy")
        val diary2 = Diary(2, "Test Title 2", "Test Content 2", "Sad")
        dbHelper.insertDiary(diary1)
        dbHelper.insertDiary(diary2)

        val diaries = dbHelper.getAllDiaries()

        assertEquals(2, diaries.size)

        val retrievedDiary1 = diaries[0]
        assertEquals(diary1.title, retrievedDiary1.title)
        assertEquals(diary1.content, retrievedDiary1.content)
        assertEquals(diary1.emotion, retrievedDiary1.emotion)

        val retrievedDiary2 = diaries[1]
        assertEquals(diary2.title, retrievedDiary2.title)
        assertEquals(diary2.content, retrievedDiary2.content)
        assertEquals(diary2.emotion, retrievedDiary2.emotion)
    }

    @Test
    fun testDeleteDiary() {
        val diary = Diary(1, "Test Title", "Test Content", "Happy")
        dbHelper.insertDiary(diary)

        var diaries = dbHelper.getAllDiaries()
        assertEquals(1, diaries.size)

        dbHelper.deleteDiary(diary.id)

        diaries = dbHelper.getAllDiaries()
        assertTrue(diaries.isEmpty())
    }
}
