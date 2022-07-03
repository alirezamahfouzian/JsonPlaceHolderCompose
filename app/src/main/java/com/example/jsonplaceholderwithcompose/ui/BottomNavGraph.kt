package com.example.jsonplaceholderwithcompose.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jsonplaceholderwithcompose.ui.sceens.AlbumsScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.CommentScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.posts.PostsScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.posts.PostsViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val postViewModel: PostsViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Post.route
    ) {
        composable(route = BottomBarScreen.Post.route) {
            PostsScreen(postViewModel)
        }
        composable(route = BottomBarScreen.Comment.route) {
            CommentScreen()
        }
        composable(route = BottomBarScreen.Albums.route) {
            AlbumsScreen()
        }
    }
}