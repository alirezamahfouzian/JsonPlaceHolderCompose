package com.example.jsonplaceholderwithcompose.ui.sceens.posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jsonplaceholderwithcompose.data.remote.dto.posts.PostsResponse
import com.example.jsonplaceholderwithcompose.ui.BottomBarScreen

@Composable
fun PostsScreen(postViewModel: PostsViewModel, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        showNextPageButton(navController)
        showPosts(postViewModel)
    }
}

@Composable
private fun showNextPageButton(navController: NavHostController) {
    OutlinedButton(
        onClick = {
            navController.navigate(BottomBarScreen.Post.route)
        }) {
        Text("NextPage")
    }
    Spacer(modifier = Modifier.height(20.dp))
}


@Composable
private fun showPosts(postViewModel: PostsViewModel) {
    val posts = produceState<List<PostsResponse>>(
        initialValue = emptyList(),
        producer = {
            value = postViewModel.getPostList()
        }
    )
    val listState: LazyListState = rememberLazyListState()
    LazyColumn(
        state = listState
    ) {
        items(posts.value) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(text = it.title, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = it.body, fontSize = 14.sp)
            }
        }
    }
}