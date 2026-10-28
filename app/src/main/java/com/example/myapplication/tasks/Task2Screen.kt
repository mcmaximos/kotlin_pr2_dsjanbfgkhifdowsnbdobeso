package com.example.myapplication.tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.Hello
import com.example.myapplication.ui.theme.MyApplicationTheme

@Preview(
    name = "portrait",
    showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=portrait"
)
@Preview(
    name = "landscape",
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFF00D700,
    device = "spec:parent=pixel_5,orientation=landscape"
)
@Preview(
    name = "round",
    showSystemUi = true,
    widthDp = 200,
    heightDp = 200,
    showBackground = true,
    backgroundColor = 0xFFFFD700,
    device = "spec:width=200dp,height=200dp,isRound=true"
)
@Composable
fun Task2Screen() {
    MyApplicationTheme {
        Box(contentAlignment = Alignment.Center){
            Hello(name = "Здравствуйте! Здравствуйте! Привет!")
        }

    }
}

