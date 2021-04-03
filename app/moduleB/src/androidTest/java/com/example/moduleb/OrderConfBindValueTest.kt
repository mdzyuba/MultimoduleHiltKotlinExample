package com.example.moduleb

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moduleb.hilt.ServicesModule
import com.example.moduleb.service.StoreService
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@UninstallModules(ServicesModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class OrderConfBindValueTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderConfirmationActivity::class.java)

    @BindValue @JvmField
    val storeService: StoreService = FakeStoreService()

    class FakeStoreService: StoreService {
        override fun isAvailable(): Boolean {
            return false
        }
    }

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun clickButtons() {
        Espresso.onView(ViewMatchers.withText("Order Confirmation"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.textView_available))
            .check(ViewAssertions.matches(ViewMatchers.withText("no")))
    }
}