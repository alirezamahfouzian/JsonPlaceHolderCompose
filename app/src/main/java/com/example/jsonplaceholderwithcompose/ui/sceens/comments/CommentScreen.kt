package com.example.jsonplaceholderwithcompose.ui.sceens.comments

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jsonplaceholderwithcompose.data.remote.dto.comment.CommentsResponse

@Composable
fun CommentScreen(commentsViewModel: CommentsViewModel) {
    val posts = produceState<List<CommentsResponse>>(
        initialValue = emptyList(),
        producer = {
            value = commentsViewModel.getComments()
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
                Text(text = it.email, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = it.body, fontSize = 14.sp)
            }
        }
    }
}