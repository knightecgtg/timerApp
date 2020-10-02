package com.example.androidtutorialfragment


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import junit.framework.Assert.assertTrue
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//This test was created using espresso record
@LargeTest
@RunWith(AndroidJUnit4::class)
class TimerTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun timerTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextNumber),
                childAtPosition(
                    allOf(
                        withId(R.id.timertext),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("10000"), closeSoftKeyboard())

        val appCompatButton = onView(
            allOf(
                withId(R.id.startTimer), withText("Start"),
                childAtPosition(
                    allOf(
                        withId(R.id.timertext),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.startTimer), withText("Start"),
                childAtPosition(
                    allOf(
                        withId(R.id.timertext),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),

                isDisplayed()
            )
        )
        appCompatButton2.perform(click())
        Thread.sleep(10000)

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.stopTimer), withText("Stop"),
                childAtPosition(
                    allOf(
                        withId(R.id.timertext),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextNumber), withText("10000"),

                childAtPosition(
                    allOf(
                        withId(R.id.timertext),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(pressImeActionButton())

        Espresso.pressBackUnconditionally()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
