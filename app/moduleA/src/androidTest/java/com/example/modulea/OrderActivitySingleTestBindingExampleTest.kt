package com.example.modulea

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.modulea.hilt.FakeOrderModule
import com.example.modulea.hilt.OrderModule
import com.example.modulea.model.Bar
import com.example.modulea.model.FakeOrder
import com.example.modulea.model.Foo
import com.example.modulea.model.Order
import com.example.modulea.remote.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.junit.*
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

// Note: combining Fake modules and unbinding in the same Gradle module does not work.
// @UninstallModules(OrderModule::class, FakeOrderModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class OrderActivitySingleTestBindingExampleTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = ActivityScenarioRule(OrderActivity::class.java)

//    @Inject
//    lateinit var order: Order

//    @Module
//    @InstallIn(SingletonComponent::class)
//    object TestModule {
//        @Provides
//        fun provideOrder() : Order {
//            return AnotherFakeOrder()
//        }
//
//        // TODO: figure out a better approach. This is an exact copy.
//
//        @Provides
//        fun provideFoo() : Foo {
//            return Foo(1)
//        }
//
//        @Provides
//        fun provideBar(): Bar {
//            return Bar()
//        }
//
//        @Provides
//        @Singleton
//        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
//            Retrofit.Builder()
//                .baseUrl("https://api.github.com")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//        @Provides
//        @Singleton
//        fun provideGitHubService(retrofit: Retrofit): GitHubService =
//            retrofit.create(GitHubService::class.java)
//    }

    class AnotherFakeOrder() : Order {
        override fun price(): Int {
            return 1
        }

        override fun address(): String {
            return "Another fake address"
        }

        override fun priority(): Int {
            return 2
        }

        override fun tax(): Int {
            return 3
        }
    }

    @Before
    fun setup() {
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun cleanUp() {
        Intents.release()
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