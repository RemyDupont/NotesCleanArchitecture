package com.remydupont.notescleanarchitecture.ui.feature_counters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddCounterDialog(
    value: String,
    modifier: Modifier = Modifier,
    onNameChange: (String) -> Unit,
    onDismissRequest: () -> Unit,
    onCreateCounterClick: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = modifier
                .background(MaterialTheme.colors.surface)
                .padding(24.dp)
        ) {
            Column {
                Text(text = "Type counter name")
                Spacer(modifier = Modifier.height(16.dp))
                TextField(value = value, onValueChange = onNameChange)
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onCreateCounterClick) {
                    Text(text = "Create counter")
                }
            }
        }
    }
}