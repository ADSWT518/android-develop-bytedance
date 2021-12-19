package me.adswt518.todolist.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TodoDbHelper(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TodoContract.SQL_CREATE_NOTES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        for (i in oldVersion until newVersion) {
            when (i) {
                1 -> db.execSQL(TodoContract.SQL_ADD_PRIORITY_COLUMN)
            }
        }
    }

    companion object {
        private const val DB_NAME = "todo.db"
        private const val DB_VERSION = 2
    }
}
