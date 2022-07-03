package com.example.jsonplaceholderwithcompose.ui.sceens.posts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jsonplaceholderwithcompose.data.remote.dto.posts.PostsResponse

@Composable
fun PostsScreen(postViewModel: PostsViewModel) {
    val posts = produceState<List<PostsResponse>>(
        initialValue = emptyList(),
        producer = {
            value = postViewModel.getPostList()
        }
    )

    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
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
}