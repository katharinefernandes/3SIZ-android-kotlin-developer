package br.com.katharine.todoapp.features.task.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.katharine.todoapp.features.task.data.local.entity.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM tasks ORDER BY isDone ASC, id DESC")
    fun getAll(): Flow<List<Task>>

    @Query("DELETE FROM Tasks")
    suspend fun clearAll()

    @Query(
        "UPDATE tasks SET isDone = :isDone WHERE id =:taskId"
    )
    suspend fun updateTaskStatus(taskId: Int, isDone: Boolean)
}