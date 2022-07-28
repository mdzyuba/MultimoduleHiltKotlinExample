package com.example.modulea.hilt

import com.example.modulea.model.Bar
import com.example.modulea.model.Foo
import com.example.modulea.model.MailOrder
import com.example.modulea.model.Order
import com.example.modulea.remote.GitHubService
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