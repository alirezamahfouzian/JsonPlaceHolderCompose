package com.example.jsonplaceholderwithcompose.ui.sceens.comments

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jsonplaceholderwithcompose.data.remote.dto.comment.CommentsResponse
import com.example.jsonplaceholderwithcompose.ui.components.GlobalLazyColumn

@Composable
fun CommentScreen(commentsViewModel: CommentsViewModel) {
    CommentsList(commentsViewModel)
}


@Composable
private fun CommentsList(commentsViewModel: CommentsViewModel) {
    val comments = produceState<List<CommentsResponse>>(
        initialValue = emptyList(),
        producer = {
            value = commentsViewModel.getComments()
        }
    )
    val listState: LazyListState = rememberLazyListState()
    GlobalLazyColumn(list = comments.value, state = listState) {
        Text(text = it.email, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = it.body, fontSize = 14.sp)
    }
}