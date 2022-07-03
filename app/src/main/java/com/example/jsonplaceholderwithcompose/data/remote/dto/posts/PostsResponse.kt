package com.example.jsonplaceholderwithcompose.data.remote.dto.posts

import kotlinx.serialization.Serializable

@Serializable
data class PostsResponse(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int
)