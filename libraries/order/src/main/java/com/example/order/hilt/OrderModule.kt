package com.example.order.hilt

import com.example.order.model.MailOrder
import com.example.order.model.Order
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OrderModule {

    @Provides
    fun provideOrder() : Order {
        return MailOrder()
    }

}