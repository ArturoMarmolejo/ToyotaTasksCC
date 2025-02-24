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


/**
 * [TasksViewModel]: Viewmodel used to handle the UI stream of data from the database to the UI
 * in a lifecycle aware manner. Notice the use of the viewmodel scope for both methods, along with
 * the [getAllTasks] method upon its initialization, in order to call the database once the user
 * opens the App and displays de main screen. Exceptions are already handled in [TaskRepository]
 */
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