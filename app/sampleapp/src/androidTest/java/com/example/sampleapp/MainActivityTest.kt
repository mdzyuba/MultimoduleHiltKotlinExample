package com.example.sampleapp

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.modulea.model.Order
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Inject
    lateinit var order: Order

    @Before
    fun setup() {
        hiltRule.inject()
        Log.d("Test", "order price:  ${order.price()}")
        assertNotNull(order)
    }

    @Test
    fun clickButtons() {
        Espresso.onView(withId(R.id.button1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("One")))
        Espresso.onView(withId(R.id.button2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Two")))
        Espresso.onView(withId(R.id.button3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.textView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Three")))
    }

    /**
     * This is an example of testing navigation between activities from different modules.
     */
    @Test
    fun checkNavigationAcrossActivities() {
        Espresso.onView(ViewMatchers.withText(R.string.multimodule_app_hello_world))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.button_order)).perform(ViewActions.click())
        // Check Order Details activity is displayed
        Espresso.onView(ViewMatchers.withText(R.string.order_details))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.button_submit)).perform(ViewActions.click())
        // Check the Order Confirmation activity is displayed
        Espresso.onView(ViewMatchers.withText(R.string.order_confirmation))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.button_home)).perform(ViewActions.click())
        // Check the navigation back to the Home activity
        Espresso.onView(ViewMatchers.withText(R.string.multimodule_app_hello_world))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}