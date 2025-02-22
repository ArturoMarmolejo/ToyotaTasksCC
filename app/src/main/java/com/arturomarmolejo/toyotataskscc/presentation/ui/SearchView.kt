package com.arturomarmolejo.toyotataskscc.presentation.ui

import android.widget.SearchView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier

@Composable
fun SearchView(
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = onSearchTextChanged,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        }
    )
}