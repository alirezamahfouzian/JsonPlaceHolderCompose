package com.example.jsonplaceholderwithcompose.ui.sceens.comments

import androidx.lifecycle.ViewModel
import com.example.jsonplaceholderwithcompose.data.remote.dto.comment.CommentsResponse
import com.example.jsonplaceholderwithcompose.data.remote.service.comments.CommentService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(private val postsService: CommentService) : ViewModel() {

    private var commentsList = emptyList<CommentsResponse>()

    suspend fun getComments(): List<CommentsResponse> {
        if (commentsList.isEmpty()) {
            postsService.getComments()?.also {
                commentsList = it
            }
        }
        return commentsList
    }
}