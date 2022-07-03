package com.example.jsonplaceholderwithcompose.ui.sceens.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
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
import com.example.jsonplaceholderwithcompose.ui.components.GlobalLazyColumn

@Composable
fun PostsScreen(postViewModel: PostsViewModel, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NextPageButton(navController)
        PostsList(postViewModel)
    }
}

@Composable
private fun NextPageButton(navController: NavHostController) {
    OutlinedButton(
        onClick = {
            navController.navigate(BottomBarScreen.Post.route)
        }) {
        Text("NextPage")
    }
    Spacer(modifier = Modifier.height(20.dp))
}


@Composable
private fun PostsList(postViewModel: PostsViewModel) {
    val posts = produceState<List<PostsResponse>>(
        initialValue = emptyList(),
        producer = {
            value = postViewModel.getPostList()
        }
    )
    val listState: LazyListState = rememberLazyListState()
    GlobalLazyColumn(list = posts.value, state = listState) {
        Text(text = it.title, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = it.body, fontSize = 14.sp)
    }
}