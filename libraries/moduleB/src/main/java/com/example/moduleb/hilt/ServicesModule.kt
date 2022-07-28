package com.example.moduleb.hilt

import com.example.moduleb.service.StoreService
import com.example.moduleb.service.StoreServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {
    @Provides
    fun provideStoreService(): StoreService {
        return StoreServiceImpl()
    }
}