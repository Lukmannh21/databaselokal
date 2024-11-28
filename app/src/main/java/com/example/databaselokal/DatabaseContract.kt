package com.example.databaselokal

import android.provider.BaseColumns

internal class DatabaseContract {
    internal class HomeworkColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "homework"
            const val ID = "_id"
            const val TITLE = "title"
            const val DESCRIPTION = "description"
            const val DATE = "date"
        }
    }
}
