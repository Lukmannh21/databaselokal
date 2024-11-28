package com.example.databaselokal

import android.database.Cursor
import com.example.sqliteapp.database.DatabaseContract
import com.example.sqliteapp.models.Homework

object MappingHelper {

    fun mapCursorToArrayList(homeworkCursor: Cursor?): ArrayList<Homework> {
        val homeworkList = ArrayList<Homework>()

        homeworkCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.COLUMN_TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.COLUMN_DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.HomeworkColumns.COLUMN_DATE))

                homeworkList.add(Homework(id, title, description, date))
            }
        }

        return homeworkList
    }
}