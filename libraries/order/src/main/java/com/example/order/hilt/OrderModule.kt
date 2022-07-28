package com.example.order.hilt

import com.example.order.model.Bar
import com.example.order.model.Foo
import com.example.order.model.MailOrder
import com.example.order.model.Order
import com.example.order.remote.GitHubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderModule {

    @Provides
    fun provideOrder() : Order {
        return MailOrder()
    }

    @Provides
    fun provideFoo() : Foo {
        return Foo(1)
    }

    @Provides
    fun provideBar(): Bar {
        return Bar()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideGitHubService(retrofit: Retrofit): GitHubService =
        retrofit.create(GitHubService::class.java)
}