package com.example.databaselokal

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class HomeworkHelper(context: Context) {

    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun close() {
        if (::database.isInitialized && database.isOpen) {
            database.close()
        }
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DatabaseContract.HomeworkColumns.TABLE_NAME, null, values)
    }

    fun queryAll(): Cursor {
        return database.query(
            DatabaseContract.HomeworkColumns.TABLE_NAME, null, null, null, null, null, "id ASC"
        )
    }

    fun update(id: String, values: ContentValues?): Int {
        return database.update(
            DatabaseContract.HomeworkColumns.TABLE_NAME,
            values,
            "id = ?",
            arrayOf(id)
        )
    }

    fun deleteById(id: String): Int {
        return database.delete(
            DatabaseContract.HomeworkColumns.TABLE_NAME,
            "id = ?",
            arrayOf(id)
        )
    }
}
