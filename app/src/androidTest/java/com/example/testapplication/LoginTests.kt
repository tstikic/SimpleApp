package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
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
    private val username = "Admin"
    private val password = "123456"

    @get:Rule
    var scenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginSuccessful() {
        onView(withId(R.id.username)).perform(typeText(username))
        onView(withHint(R.string.password_hint_text)).perform(typeText(password))
        onView(withText(R.string.login_button_text)).perform(click())
        onView(withId(R.id.welcome_text)).check(matches(withText(R.string.welcome_qa_family)))
    }

}