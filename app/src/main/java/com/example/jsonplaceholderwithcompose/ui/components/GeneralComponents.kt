package com.example.jsonplaceholderwithcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> GlobalLazyColumn(
    list: List<T>,
    state: LazyListState,
    row: @Composable (T) -> Unit
) {
    LazyColumn(
        state = state
    ) {
        items(list) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                row(it)
            }
        }
    }
}