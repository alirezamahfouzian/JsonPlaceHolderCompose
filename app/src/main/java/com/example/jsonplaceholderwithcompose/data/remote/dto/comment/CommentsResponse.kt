package com.example.jsonplaceholderwithcompose.data.remote.dto.comment

import kotlinx.serialization.Serializable

@Serializable
data class CommentsResponse(
    val postId: String,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)