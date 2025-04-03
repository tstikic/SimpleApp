package com.example.testapplication

import android.content.Intent
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScreenThreeTests {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(ScrollableActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.init()
    }

    @Test
    fun checkThirdScreenElements() {
        onView(withId(R.id.title_text)).check(matches(withText(R.string.why_testing_matters_title)))

        onView(withId(R.id.carousel_text)).check(matches(withText("Android Testing")))
        onView(withId(R.id.carousel)).perform(swipeLeft())
        onView(allOf(withId(R.id.carousel_text), withText("iOS testing"))).check(matches(isDisplayed()))
        onView(withId(R.id.carousel)).perform(swipeLeft())
        onView(allOf(withId(R.id.carousel_text), withText("Web browser testing"))).check(matches(isDisplayed()))

        onView(withId(R.id.start_learning_button)).perform(scrollTo(), click())

        intended(hasComponent(RecyclerActivity::class.java.name))
    }

}