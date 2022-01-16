package com.remydupont.notescleanarchitecture.ui.feature_counters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.remydupont.notescleanarchitecture.ui.common.components.AppSnackBar

@Composable
fun CountersScreen(
    viewModel: CountersViewModel = hiltViewModel()
) {

    val state = viewModel.uiState.value
    val scaffoldState = rememberScaffoldState()
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                      openDialog.value = true
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
            }
        },
        scaffoldState = scaffoldState,
        snackbarHost = { AppSnackBar(hostState = it) }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.counters) { counter ->
                    CounterItem(counter = counter)
                }
            }

            if (openDialog.value) {
                val newCounterNameState = viewModel.newCounterNameState.value
                AddCounterDialog(
                    value = newCounterNameState,
                    modifier = Modifier,
                    onNameChange = { newValue ->
                        viewModel.onEvent(CountersEvent.UpdateCounterName(newValue))
                    },
                    onDismissRequest = {
                        openDialog.value = false
                        viewModel.onEvent(CountersEvent.CancelNewCounter)
                    },
                    onCreateCounterClick = {
                        openDialog.value = false
                        viewModel.onEvent(CountersEvent.SaveCounter)
                    }
                )
            }
        }
    }
}