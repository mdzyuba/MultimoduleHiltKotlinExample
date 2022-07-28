package com.example.product

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailsActivityTest {

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(ProductDetailsActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun onCreate() {
        Espresso.onView(ViewMatchers.withId(R.id.label))
            .check(ViewAssertions.matches(ViewMatchers.withText("Product Details")))
    }
}