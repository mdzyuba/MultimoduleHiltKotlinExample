package com.example.sampleapp.hilt

import com.example.sampleapp.repository.Store
import com.example.sampleapp.repository.ToyStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object StoreHiltModule {

    @Provides
    fun provideStore(): Store {
        return ToyStore()
    }
}