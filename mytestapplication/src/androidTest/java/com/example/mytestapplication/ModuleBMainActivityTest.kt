package com.example.mytestapplication

import android.util.Log
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.modulea.model.Order
import com.example.moduleb.ModuleBMainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class ModuleBMainActivityTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(ModuleBMainActivity::class.java)

    @Inject
    lateinit var order: Order

    @Before
    fun setup() {
        hiltRule.inject()
        Log.d("Test", "order price:  ${order.price()}")
    }

    @Test
    fun checkLabel() {
        Espresso.onView(withId(R.id.textView)).check(ViewAssertions.matches(withText("Module B")))
    }
}