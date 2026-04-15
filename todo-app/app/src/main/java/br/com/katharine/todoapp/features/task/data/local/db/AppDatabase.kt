package br.com.katharine.todoapp.features.task.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.katharine.todoapp.features.task.data.local.dao.TaskDao
import br.com.katharine.todoapp.features.task.data.local.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}