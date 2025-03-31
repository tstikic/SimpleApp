package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomePageTests {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun checkHomePageDisplayedCorrectly() {
        onView(withId(R.id.welcome_text)).check(matches(withText(R.string.welcome_qa_family)))
        onView(withId(R.id.image)).check(matches(isDisplayed()))
        onView(withId(R.id.go_to_recycler_view_button)).check(matches(isClickable()))
    }
}
