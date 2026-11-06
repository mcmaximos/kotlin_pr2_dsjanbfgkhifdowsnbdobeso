package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.myapplication.tasks.WaterTracker
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // 1) Проверить наличие и корректную работу кнопки добавления жидкости
    @Test
    fun testAddWaterButton_increasesWaterCount() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("addWaterButton").assertIsDisplayed()
        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("0 мл")

        composeTestRule.onNodeWithTag("addWaterButton").performClick()
        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("250 мл")

        composeTestRule.onNodeWithTag("addWaterButton").performClick()
        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("500 мл")
    }

    // 2) Проверить наличие и корректную работу кнопки “Завершить день”
    @Test
    fun testFinishDayButton_resetsWaterCountAndUpdatesStreak() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("finishDayButton").assertIsDisplayed()

        // Нажмем 2 раза (+500 мл, меньше 1500 мл)
        composeTestRule.onNodeWithTag("addWaterButton").performClick()
        composeTestRule.onNodeWithTag("addWaterButton").performClick()

        composeTestRule.onNodeWithTag("finishDayButton").performClick()

        // Вода должна сброситься до 0 мл, счетчик дней должен остаться 0
        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("0 мл")
        composeTestRule.onNodeWithTag("streakDaysText").assertTextEquals("Дней подряд (>= 1500 мл): 0")
    }

    // 3) Проверить, что выводится необходимый текст со значением количества дней подряд при выпивании >= 1500 мл
    @Test
    fun testStreakDaysIncrement_whenWater1500OrMore() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Выпиваем 6 стаканов по 250 мл = 1500 мл
        repeat(6) {
            composeTestRule.onNodeWithTag("addWaterButton").performClick()
        }

        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("1500 мл")

        // Завершаем день
        composeTestRule.onNodeWithTag("finishDayButton").performClick()

        // Проверяем, что дни подряд = 1, а вода сбросилась до 0 мл
        composeTestRule.onNodeWithTag("waterCountText").assertTextEquals("0 мл")
        composeTestRule.onNodeWithTag("streakDaysText").assertTextEquals("Дней подряд (>= 1500 мл): 1")
    }
}
