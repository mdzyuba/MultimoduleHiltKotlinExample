package com.example.shipping.di

import com.example.order.model.AddressProvider
import com.example.shipping.address.AddressProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ShippingModule {

    @Binds
    abstract fun bindAddressProvider(addressProvider: AddressProviderImpl): AddressProvider
}