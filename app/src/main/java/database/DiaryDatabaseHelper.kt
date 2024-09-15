package com.example.emotnionsdiary.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DiaryDatabaseHelper(context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "my_db"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "diary"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"
        private const val COLUMN_EMOTION = "emotion"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITLE TEXT,
                $COLUMN_CONTENT TEXT,
                $COLUMN_EMOTION TEXT
            );
        """
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(query)
        onCreate(db)
    }

    fun insertDiary(diary: Diary) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, diary.title)
            put(COLUMN_CONTENT, diary.content)
            put(COLUMN_EMOTION, diary.emotion)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }


    fun getAllDiaries(): ArrayList<Diary> {
        val diaries = ArrayList<Diary>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        cursor.use {
            while (it.moveToNext()) {
                val id = it.getInt(it.getColumnIndexOrThrow(COLUMN_ID))
                val title = it.getString(it.getColumnIndexOrThrow(COLUMN_TITLE))
                val content = it.getString(it.getColumnIndexOrThrow(COLUMN_CONTENT))
                val emotion = it.getString(it.getColumnIndexOrThrow(COLUMN_EMOTION))

                val diary = Diary(id, title, content, emotion)
                diaries.add(diary)
            }
        }
        db.close()
        return diaries
    }

}