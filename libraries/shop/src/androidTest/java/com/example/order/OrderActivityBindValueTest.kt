package com.example.order

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.order.hilt.OrderModule
import com.example.order.model.Order
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@UninstallModules(OrderModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class OrderActivityBindValueTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderActivity::class.java)

    // This does not work because FakeOrderModule.provideOrder()
    // error: [Dagger/DuplicateBindings] Order is bound multiple times:
    //    @BindValue @JvmField
    //    val order: Order = AnotherFakeOrder()

    @Before
    fun setup() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun cleanUp() {
        Intents.release()
    }

    class AnotherFakeOrder: Order {
        override fun product(): String {
            return "Tea"
        }

        override fun price(): Int {
            return 1
        }

        override fun address(): String {
            return "Another fake address"
        }

        override fun priority(): Int {
            return 1
        }

        override fun tax(): Int {
            return 1
        }
    }

    @Test
    fun clickButtons() {
        Espresso.onView(ViewMatchers.withText("Order Details"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // Note: FakeOrderModule replaces the Order object. So, instead of "Mailing address",
        // we are expecting "Fake address" in all the tests.
        Espresso.onView(ViewMatchers.withId(R.id.textView_address_value))
            .check(ViewAssertions.matches(ViewMatchers.withText("Fake address")))
    }
}