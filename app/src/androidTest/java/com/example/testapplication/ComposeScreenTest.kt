package com.example.testapplication

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposeScreenTest {
    @get:Rule(order = 0)
    var scenarioRule = ActivityScenarioRule(ComposeActivity::class.java)

    @get:Rule
    var composeTestRule = createComposeRule()

    @Test
    fun checkComposeScreenElements() {
        composeTestRule.onNode(hasTestTag(IMAGE_TEST_TAG)).isDisplayed()
        composeTestRule.onNode(hasTestTag(BUTTON_TEXT_TEST_TAG), useUnmergedTree = true)
            .assertTextContains(
                value = "click me",
                ignoreCase = true
            ).performClick()
        composeTestRule.onNode(hasText(
            text = "You clicked the button",
            substring = true,
            ignoreCase = true
        ))
    }
}