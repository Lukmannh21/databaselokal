package com.example.databaselokal

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbhomework"
        private const val DATABASE_VERSION = 1

        private const val CREATE_TABLE = """
            CREATE TABLE ${DatabaseContract.HomeworkColumns.TABLE_NAME} (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                ${DatabaseContract.HomeworkColumns.TITLE} TEXT NOT NULL,
                ${DatabaseContract.HomeworkColumns.DESCRIPTION} TEXT,
                ${DatabaseContract.HomeworkColumns.DATE} TEXT NOT NULL
            );
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${DatabaseContract.HomeworkColumns.TABLE_NAME}")
        onCreate(db)
    }
}
