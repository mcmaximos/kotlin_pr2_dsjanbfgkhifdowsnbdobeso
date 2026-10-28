package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.tasks.ShoppingCartScreen
import com.example.myapplication.tasks.Task1Screen
import com.example.myapplication.tasks.Task2Screen
import com.example.myapplication.tasks.Task3Screen
import com.example.myapplication.tasks.Task4Screen
import com.example.myapplication.tasks.Task5Screen
import com.example.myapplication.tasks.Task6Screen
import com.example.myapplication.tasks.Task7Screen
import com.example.myapplication.tasks.WaterTracker
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Hello(name: String?) {
    Text(
        text = name ?: "Имя не задано",
        modifier = Modifier.padding(16.dp)
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainTasksContainer()

            }
        }
    }
}

@Composable
fun MainTasksContainer() {
    val tasksList = listOf(
        "Задание 1",
        "Задание 2",
        "Задание 3",
        "Задание 4",
        "Задание 5",
        "Задание 6",
        "Задание 7",
        "Задание 8",
        "Задание 10"
    )
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 8.dp
        ) {
            tasksList.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(text = title) }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            when (selectedTab) {
                0 -> Task1Screen()
                1 -> Task2Screen()
                2 -> Task3Screen()
                3 -> Task4Screen()
                4 -> Task5Screen()
                5 -> Task6Screen()
                6 -> Task7Screen()
                7 -> WaterTracker()
                8 -> ShoppingCartScreen()
            }
        }
    }
}





