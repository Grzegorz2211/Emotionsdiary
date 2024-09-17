package com.example.emotnionsdiary

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DiaryFragmentTest {

    @Before
    fun setUp() {
        launchFragmentInContainer<DiaryFragment>(themeResId = R.style.Theme_NavigationDrawer)
    }

    @Test
    fun testInitialState() {
        onView(withId(R.id.input_emotionsEditText)).check(matches(withText("")))
        onView(withId(R.id.contentEditText)).check(matches(withText("")))
        onView(withId(R.id.diaryNextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun testSingleTitleInput() {
        val title = "A"
        val content = "Some content"

        onView(withId(R.id.input_emotionsEditText)).perform(typeText(title))
        onView(withId(R.id.contentEditText)).perform(typeText(content))
        closeSoftKeyboard()

        onView(withId(R.id.input_emotionsEditText)).check(matches(withText(title)))
        onView(withId(R.id.contentEditText)).check(matches(withText(content)))
    }

    @Test
    fun testSingleContentInput() {
        val title = "Some title"
        val content = "A"

        onView(withId(R.id.input_emotionsEditText)).perform(typeText(title))
        onView(withId(R.id.contentEditText)).perform(typeText(content))
        closeSoftKeyboard()

        onView(withId(R.id.input_emotionsEditText)).check(matches(withText(title)))
        onView(withId(R.id.contentEditText)).check(matches(withText(content)))
    }

    @Test
    fun testEmptyInputs() {
        onView(withId(R.id.input_emotionsEditText)).perform(typeText(""))
        onView(withId(R.id.contentEditText)).perform(typeText(""))
        closeSoftKeyboard()

        onView(withId(R.id.input_emotionsEditText)).check(matches(withText("")))
        onView(withId(R.id.contentEditText)).check(matches(withText("")))
    }

    @Test
    fun testDisplayedTextInputs() {
        onView(withId(R.id.input_emotionsEditText)).check(matches(isDisplayed()))
        onView(withId(R.id.contentEditText)).check(matches(isDisplayed()))
        onView(withId(R.id.diaryNextButton)).check(matches(isDisplayed()))
    }
}