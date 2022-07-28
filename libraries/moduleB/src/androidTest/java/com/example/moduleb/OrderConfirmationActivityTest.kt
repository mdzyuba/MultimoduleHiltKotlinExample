package com.example.moduleb

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
OrderConfirmationActivity is @AndroidEntryPoint.

Running this test without @HiltAndroidTest generates this error:

Didn't find class "dagger.hilt.android.internal.testing.TestComponentDataSupplierImpl"
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class OrderConfirmationActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderConfirmationActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun clickButtons() {

        Espresso.onView(ViewMatchers.withText("Order Confirmation"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}