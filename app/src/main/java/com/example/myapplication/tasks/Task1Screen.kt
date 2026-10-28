package com.example.myapplication.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.myapplication.Hello

@Composable
fun Task1Screen(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Вызов с конкретным именем:", style = MaterialTheme.typography.titleMedium)
        Hello(name = "Конкретное имя")
        Text(text = "Вызов с null:", style = MaterialTheme.typography.titleMedium)
        Hello(name = null)

    }
}