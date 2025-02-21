package com.arturomarmolejo.toyotataskscc.data.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arturomarmolejo.toyotataskscc.R
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import com.arturomarmolejo.toyotataskscc.data.presentation.viewmodel.TasksViewModel

@Composable
fun DetailScreen(
    tasksViewModel: TasksViewModel,
    navController: NavController
) {
    var taskName by remember {
        mutableStateOf("")
    }
    var taskDefinition by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = taskName,
            onValueChange = {
                taskName = it
            },
            label = {
                Text(text = stringResource(R.string.task_name))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = taskDefinition,
            onValueChange = {
                taskDefinition = it
            },
            label = {
                Text(text = stringResource(R.string.task_definition))
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Cancel")
            }
            Button(onClick = {
                val newTask = TaskEntity(
                    taskName = taskName,
                    taskDefinition = taskDefinition
                )
                tasksViewModel.insertTask(newTask)
                navController.popBackStack()
            }) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}