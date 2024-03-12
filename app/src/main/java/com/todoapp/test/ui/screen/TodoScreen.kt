package com.todoapp.test.ui.screen


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.todoapp.test.ui.viewModel.TodoViewModel


@Composable
fun TodoScreen(todoViewModel: TodoViewModel = hiltViewModel()) {
    val todos = todoViewModel.todos.collectAsState()

    LazyColumn {
        items(todos.value) { todo ->
            if (todo.isHeader) {
                TodoListHeader(title = todo.title)
            } else {
                TodoItem(todo = todo)
            }
        }
    }
}

