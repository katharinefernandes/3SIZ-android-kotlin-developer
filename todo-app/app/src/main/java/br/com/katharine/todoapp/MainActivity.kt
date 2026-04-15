package br.com.katharine.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import br.com.katharine.todoapp.features.task.data.local.db.AppDatabase
import br.com.katharine.todoapp.features.task.data.local.repository.TaskRepository
import br.com.katharine.todoapp.ui.screen.TaskScreen
import br.com.katharine.todoapp.ui.screen.TaskViewModel
import br.com.katharine.todoapp.ui.theme.ToDoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_db"
        ).build()
        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)
        setContent {
            ToDoAppTheme {
                TaskScreen(viewModel)
            }
        }
    }
}
