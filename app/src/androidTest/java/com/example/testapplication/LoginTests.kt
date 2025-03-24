package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTests {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginSuccessful() {
        onView(withId(R.id.username)).perform(typeText("Admin"))
        onView(withHint("Password:")).perform(typeText("123456"))
        onView(withText("LOGIN")).perform(click())
        onView(withId(R.id.welcome_text)).check(matches(withText("Welcome QA Family!")))
    }

}