package com.example.mytestapplication

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moduleb.ModuleBMainActivity
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ModuleBMainActivityRegularTest : TestCase() {

    @get:Rule
    var activityRule = ActivityScenarioRule(ModuleBMainActivity::class.java)

    @Test
    fun clickButtons() {
        Espresso.onView(ViewMatchers.withText("Module B"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}