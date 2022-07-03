package com.example.jsonplaceholderwithcompose.data.remote.dto.album

import kotlinx.serialization.Serializable

@Serializable
data class AlbumsResponse(
    val userId: Int,
    val id: Int,
    val title: String,
)