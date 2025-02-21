package com.arturomarmolejo.toyotataskscc.data.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity

@Composable
fun TaskList(tasks: List<TaskEntity>) {
    // UI content for the task list
    LazyColumn {
        itemsIndexed( key = { _, task -> task.id }, items = tasks) { _, task ->
            TaskCardItem(task)
        }
    }
}