package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScreenThreeTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(ScrollableActivity::class.java)

    /**
     * A test for practicing swipe() action and resolving "AmbiguousViewMatcherException" error using allOf() - matcher combination
     */
    @Test
    fun checkSwipeIsWorking() {
        onView(allOf(withId(R.id.carousel_text), withText("Android Testing"))).check(matches(isDisplayed()))
        onView(withId(R.id.carousel)).perform(swipeLeft())
        onView(allOf(withId(R.id.carousel_text), withText("iOS testing"))).check(matches(isDisplayed()))
        onView(withId(R.id.carousel)).perform(swipeLeft())
        onView(allOf(withId(R.id.carousel_text), withText("Web browser testing"))).check(matches(isDisplayed()))
        // match with id and scroll, check chain

        onView(withId(R.id.espresso_title))
            .perform(scrollTo())
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.espresso_for_android_title)))

        onView(withText(R.string.espresso_subtext))
            .perform(scrollTo())
            .check(matches(isDisplayed()))

        onView(withId(R.id.start_learning_button))
            .perform(scrollTo(), click())

        // verify screen is displayed bla bla
        onView(withId(R.id.workshop_join_root)).check(matches(isDisplayed()))
    }


}