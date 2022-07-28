package com.example.order.hilt

import com.example.order.model.OrderImpl
import com.example.order.model.Order
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class OrderModule {

    @Binds
    abstract fun bindOrder(order: OrderImpl): Order

}