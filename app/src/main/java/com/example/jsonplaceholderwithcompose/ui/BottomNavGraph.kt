package com.example.jsonplaceholderwithcompose.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jsonplaceholderwithcompose.ui.sceens.albums.AlbumsScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.albums.AlbumsViewModel
import com.example.jsonplaceholderwithcompose.ui.sceens.comments.CommentScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.comments.CommentsViewModel
import com.example.jsonplaceholderwithcompose.ui.sceens.posts.PostsScreen
import com.example.jsonplaceholderwithcompose.ui.sceens.posts.PostsViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val postViewModel: PostsViewModel = hiltViewModel()
    val commentsViewModel: CommentsViewModel = hiltViewModel()
    val albumsViewModel: AlbumsViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Post.route
    ) {
        composable(route = BottomBarScreen.Post.route) {
            PostsScreen(postViewModel)
        }
        composable(route = BottomBarScreen.Comment.route) {
            CommentScreen(commentsViewModel)
        }
        composable(route = BottomBarScreen.Albums.route) {
            AlbumsScreen(albumsViewModel)
        }
    }
}