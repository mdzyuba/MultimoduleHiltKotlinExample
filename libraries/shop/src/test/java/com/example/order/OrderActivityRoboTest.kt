package com.example.order

import android.os.Build
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = HiltTestApplication::class, sdk = [Build.VERSION_CODES.O_MR1])
@HiltAndroidTest
class OrderActivityRoboTest {

    @get:Rule(order = 0)
    var hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderActivity::class.java)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
        activityRule.scenario.moveToState(Lifecycle.State.CREATED)
    }

    @Test
    fun testGetOrder() {
        activityRule.scenario.onActivity {
            assertNotNull(it?.order)
            assertNotNull(it?.foo)
            assertNotNull(it?.bar)
        }
    }
}