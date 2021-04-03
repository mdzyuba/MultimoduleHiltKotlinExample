package com.example.sampleapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleapp.hilt.StoreHiltModule
import com.example.sampleapp.repository.FakeToyStore
import com.example.sampleapp.repository.Store
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@UninstallModules(StoreHiltModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class FakeStoreActivityTest : TestCase() {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(StoreActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Module
    @InstallIn(ActivityComponent::class)
    object FakeStoreHiltModule {
        @Provides
        fun provideStore(): Store {
            return FakeToyStore()
        }
    }

    @Test
    fun testService() {
        activityRule.scenario.onActivity { activity ->
            assertEquals("FakeToyStore", activity.store.name())
        }
    }

    fun foo() {

    }
}