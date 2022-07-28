package com.example.order.hilt

import com.example.order.model.FakeOrder
import com.example.order.model.Order
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

// This injects the fake object for all the tests.
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [OrderModule::class]
)
object FakeOrderModule {

    @Provides
    fun provideOrder() : Order {
        return FakeOrder()
    }

}