package com.example.jsonplaceholderwithcompose.di

import com.example.jsonplaceholderwithcompose.data.remote.service.posts.PostsService
import com.example.jsonplaceholderwithcompose.data.remote.service.posts.PostsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    @Provides
    fun providePostsService(httpClient: HttpClient): PostsService =
        PostsServiceImpl(client = httpClient)

}