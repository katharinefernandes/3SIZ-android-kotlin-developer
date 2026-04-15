package br.com.katharine.todoapp.features.task.data.local.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
 ALTER TABLE tasks
 ADD COLUMN isDone INTEGER NOT NULL DEFAULT 0
 """.trimIndent()
        )
    }
}