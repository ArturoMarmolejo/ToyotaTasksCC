package com.arturomarmolejo.toyotataskscc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.arturomarmolejo.toyotataskscc.presentation.navigation.TaskNavigation
import com.arturomarmolejo.toyotataskscc.presentation.viewmodel.TasksViewModel
import com.arturomarmolejo.toyotataskscc.ui.theme.ToyotaTasksCCTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToyotaTasksCCTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    val tasksViewModel: TasksViewModel = hiltViewModel()
                    TaskNavigation(tasksViewModel)
                }
            }
        }
    }
}