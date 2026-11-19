package com.example.testapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomePageTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(HomeActivity::class.java)


    // Test for checkHomePageScreen() goes here:
    // 1. Image is displayed
    // 2. Title is displayed
    // 3. Body text is displayed
    // 4. Button with correct text and clickable action is displayed
}