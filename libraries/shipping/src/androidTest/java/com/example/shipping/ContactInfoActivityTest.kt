package com.example.shipping

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class ContactInfoActivityTest {

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(ContactInfoActivity::class.java)

    @Test
    fun onCreate() {
        Espresso.onView(ViewMatchers.withId(R.id.label))
            .check(ViewAssertions.matches(ViewMatchers.withText("Contact Info")))
    }
}