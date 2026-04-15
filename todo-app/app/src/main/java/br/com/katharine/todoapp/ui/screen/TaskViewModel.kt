package br.com.katharine.todoapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.katharine.todoapp.features.task.data.local.entity.Task
import br.com.katharine.todoapp.features.task.data.local.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks = repository.tasks

    fun addTask(title: String) {
        viewModelScope.launch {
            repository.insert(Task(title = title))
        }
    }

    fun removeTask(task: Task) {
        viewModelScope.launch {
            repository.delete(task)
        }
    }

    fun clearAllTasks() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}