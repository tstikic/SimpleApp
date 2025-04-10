package com.example.testapplication

import android.app.Instrumentation
import android.content.Intent
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.matcher.IntentMatchers.hasPackage
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DocumentUploadScreenTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(DocumentUploadActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checkDocumentUploadScreen() {
        onView(withId(R.id.input_name)).check(matches(withHint("Enter your name")))
        onView(withId(R.id.input_name)).perform(typeText("Silvia"))

        onView(withId(R.id.input_surname)).check(matches(withHint("Enter your surname")))
        onView(withId(R.id.input_surname)).perform(typeText("Jimenez"))

        onView(withId(R.id.input_address)).check(matches(withHint("Enter your address")))
        onView(withId(R.id.input_address)).perform(typeText("Plaza de Honduras"))

        onView(withId(R.id.button_open_maps)).perform(click())
        Intents.intended(hasPackage("com.google.android.apps.maps"))

        onView(withId(R.id.input_document_id)).check(matches(withHint("Enter document ID")))
        onView(withId(R.id.input_document_id)).perform(typeText("12345678P"))

        onView(withText("Take a picture of your document:")).check(matches(isDisplayed()))
        onView(withId(R.id.button_open_camera)).perform(click())
        Intents.intended(hasAction(MediaStore.ACTION_IMAGE_CAPTURE))
    }
}
