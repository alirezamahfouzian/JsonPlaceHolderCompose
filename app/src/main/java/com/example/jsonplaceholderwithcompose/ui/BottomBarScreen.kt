package com.example.jsonplaceholderwithcompose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

const val POSTS = "Posts"
const val COMMENTS = "Comments"
const val ALBUMS = "Albums"

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Post : BottomBarScreen(
        route = POSTS,
        title = POSTS,
        icon = Icons.Default.Home
    )

    object Comment : BottomBarScreen(
        route = COMMENTS,
        title = COMMENTS,
        icon = Icons.Default.Email
    )

    object Albums : BottomBarScreen(
        route = ALBUMS,
        title = ALBUMS,
        icon = Icons.Default.Settings
    )
}