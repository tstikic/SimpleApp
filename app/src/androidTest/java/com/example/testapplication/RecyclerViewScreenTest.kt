package com.example.testapplication

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToLastPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.equalToIgnoringCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecyclerViewScreenTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(RecyclerActivity::class.java)

    @Test
    fun verifyRecyclerViewScreen() {
        onView(withId(R.id.recycler_view))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withText("Dan")).perform(click())
        onView(allOf(withId(R.id.item_subtitle), withText("QA member 1"))).check(matches(isDisplayed()))

        onView(withId(R.id.recycler_view))
            .perform(scrollToLastPosition<RecyclerView.ViewHolder>())
        onView(withText("Leandro")).perform(click())
        onView(allOf(withId(R.id.item_subtitle), withText("QA member 8"))).check(matches(isDisplayed()))
        onView(allOf(withText(equalToIgnoringCase("add data")), hasSibling(withText("Leandro")))).check(
            matches(isDisplayed()))
        onView(allOf(withId(R.id.compose_screen_btn), withText("Open Compose Screen")))
            .check(matches(isDisplayed()))
            .perform(click())
    }

}