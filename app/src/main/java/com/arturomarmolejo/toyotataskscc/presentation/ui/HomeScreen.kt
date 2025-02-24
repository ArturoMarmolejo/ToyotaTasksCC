package com.arturomarmolejo.toyotataskscc.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.arturomarmolejo.toyotataskscc.R
import com.arturomarmolejo.toyotataskscc.core.UIState
import com.arturomarmolejo.toyotataskscc.data.model.TaskEntity
import com.arturomarmolejo.toyotataskscc.presentation.navigation.Routes
import com.arturomarmolejo.toyotataskscc.presentation.viewmodel.TasksViewModel

@Composable
fun HomeScreen(
    tasksViewModel: TasksViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Routes.DetailScreen.route)
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) { innerPadding ->
        Box(modifier = modifier.fillMaxSize()) {
            // Collection of the allTasks flow in a lifecycle aware manner.
            when (val uiState = tasksViewModel.allTasks.collectAsStateWithLifecycle().value) {
                is UIState.LOADING -> {
                    CircularProgressIndicator()
                }

                is UIState.SUCCESS -> {
                    Column {
                        Text(
                            modifier = modifier.padding(8.dp),
                            text = stringResource(R.string.list_of_tasks),
                            style = MaterialTheme.typography.headlineMedium
                        )
                        SearchView(
                            searchText = searchText,
                            onSearchTextChanged = { newText ->
                                searchText = newText
                            }
                        )
                        val filteredTasks = if (searchText.isBlank()) {
                            uiState.response
                        } else {
                            uiState.response.filter {
                                it.taskName.contains(
                                    searchText, ignoreCase = true
                                )
                            }
                        }
                        TaskList(tasks = filteredTasks)
                    }
                }
                is UIState.ERROR -> {
                    Text(
                        text = uiState.message,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}