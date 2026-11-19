package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    val username = "Admin"
    val wrong_password = "127668658"


    // add click on login button
    // add verification that the homepage screen is displayed (maybe verify the image view from the next screen is displayed or choose some other element)
    /**
     * Test for practicing simple View matching and view assertions
     */
    @Test
    fun checkSuccessfulLogin() {
        onView(withId(R.id.imageView5)).check(matches(isDisplayed()))
        onView(allOf(withText(R.string.welcome_qa_family), isDisplayed()))
        onView(withId(R.id.login_button)).check(matches(withText("Login")))
        onView(withId(R.id.username)).check(matches(withHint(R.string.username_hint_text)))
    }

    /**
     * Test for practicing hasErrorText matcher
     */
    @Test
    fun checkEmptyPassword() {
        onView(withId(R.id.username)).perform(typeText(username))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.password)).check(matches(hasErrorText("You need to enter password")))
    }

    /**
     * Test for practicing simple case of error text as a regular TextView
     */
    @Test
    fun checkWrongPassword() {
        onView(withId(R.id.username)).perform(typeText(username))
        onView(withId(R.id.password)).perform(typeText(wrong_password))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.error_message)).check(matches(withText(R.string.wrong_password_or_username)))
    }

    // a test checkEmptyUsername goes here

    // a test checkWrongUsername goes here

    // a test checkEmptyPasswordAndUsername goes here
}