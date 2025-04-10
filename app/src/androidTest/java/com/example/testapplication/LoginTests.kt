package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.equalToIgnoringCase
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


    @Test
    fun checkEmptyUsername() {
        onView(withId(R.id.password)).perform(typeText(password))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.username)).check(matches(hasErrorText(getTextFromStringResource(R.string.empty_username))))
    }

    @Test
    fun checkEmptyPasswordUnsuccessfulLogin(){
        onView(withId(R.id.username)).perform((typeText(username)))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.password)).check(matches(hasErrorText(getTextFromStringResource(R.string.empty_password))))
    }

    @Test
    fun checkEmptyCredentialsUnsuccessfulLogin(){
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.username)).check(matches(hasErrorText(getTextFromStringResource(R.string.empty_username))))
    }

    @Test
    fun checkWrongUsernameUnsuccessfulLogin(){
        onView(withId(R.id.username)).perform((typeText("abcd")))
        onView(withId(R.id.password)).perform(typeText(password))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.error_message)).check(matches(hasErrorText(getTextFromStringResource(R.string.wrong_password_or_username))))
    }

    @Test
    fun checkWrongPasswordUnsuccessfulLogin(){
        onView(withId(R.id.username)).perform((typeText(username)))
        onView(withId(R.id.password)).perform(typeText("654321"))
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.error_message)).check(matches(withText(getTextFromStringResource(R.string.wrong_password_or_username))))
    }

    private fun getTextFromStringResource(stringResource: Int) =
        InstrumentationRegistry.getInstrumentation().targetContext.getString(stringResource)
}