package com.example.modulea

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class OrderActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun cleanUp() {
        Intents.release()
    }

    @Test
    fun clickButtons() {
        Espresso.onView(ViewMatchers.withText("Order Details"))
            .check(matches(ViewMatchers.isDisplayed()))
        // Note: FakeOrderModule replaces the Order object. So, instead of "Mailing address",
        // we are expecting "Fake address" in all the tests.
        Espresso.onView(ViewMatchers.withId(R.id.textView_address_value))
            .check(matches(ViewMatchers.withText("Fake address")))

        // TODO: fix No Activity found to handle Intent
        // { act=com.example.sampleapp.order.CONFIRMATION pkg=com.example.modulea.test }
        // Espresso.onView(ViewMatchers.withId(R.id.button_submit)).perform(ViewActions.click())
        // Intents.intended(hasAction("com.example.sampleapp.order.CONFIRMATION"))

        // Checking for views in another activity from a different module does not work:
        // "androidx.test.espresso.NoActivityResumedException: No activities in stage RESUMED.
        // Did you forget to launch the activity. (test.getActivity() or similar)?"
        //        Espresso.onView(ViewMatchers.withText("Order Confirmation"))
        //            .check(matches(ViewMatchers.isDisplayed()))
        //        Espresso.onView(ViewMatchers.withText("Edit")).perform(ViewActions.click())
    }

    @Test
    fun testFields() {
        activityRule.scenario.onActivity {
            assertNotNull(it.order)
        }
    }

}