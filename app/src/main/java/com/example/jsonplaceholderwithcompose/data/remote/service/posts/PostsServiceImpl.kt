package com.example.jsonplaceholderwithcompose.data.remote.service.posts

import com.example.jsonplaceholderwithcompose.data.remote.dto.posts.PostsResponse
import com.example.jsonplaceholderwithcompose.data.remote.util.HttpRoutes
import com.example.jsonplaceholderwithcompose.data.remote.util.generalResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PostsServiceImpl(
    private val client: HttpClient
) : PostsService {

    override suspend fun getPosts(): List<PostsResponse>? =
        generalResponse { client.get { url(HttpRoutes.POSTS_URL) } }
}
