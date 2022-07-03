package com.example.jsonplaceholderwithcompose.data.remote.service.posts

import com.example.jsonplaceholderwithcompose.data.remote.dto.posts.PostsResponse

interface PostsService {
    suspend fun getPosts(): List<PostsResponse>?
}