package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
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

    // verify title on login screen
    //type username
    //type password
    //click login
    // verify image is displayed
    @Test
    fun checkSuccessfulLogin() {
        onView(withId(R.id.imageView5)).check(matches(isDisplayed()))
        onView(allOf(withText("Welcome QA Family!"), isDisplayed()))
        onView(withId(R.id.login_button)).check(matches(withText("Login")))
        onView(withId(R.id.username)).check(matches(withHint("Username:")))
    }
}