package com.arturomarmolejo.toyotataskscc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturomarmolejo.toyotataskscc.core.UIState
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import com.arturomarmolejo.toyotataskscc.data.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel() {

    private val _allTasks: MutableStateFlow<UIState<List<TaskEntity>>> = MutableStateFlow(UIState.LOADING)
    val allTasks: StateFlow<UIState<List<TaskEntity>>> get() = _allTasks

    init {
        getAllTasks()
    }

    fun insertTask(task: TaskEntity) {
        viewModelScope.launch {
            try {
                taskRepository.insertTask(task)
                // Refresh list of tasks
                getAllTasks()
            } catch (e: Exception) {
                _allTasks.value = UIState.ERROR(e.message ?: "Unknown error")
            }
        }
    }

    private fun getAllTasks() {
        viewModelScope.launch {
            taskRepository.getAllTasks().collect {
                _allTasks.value = it
            }
        }
    }

}