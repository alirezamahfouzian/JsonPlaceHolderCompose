package com.example.jsonplaceholderwithcompose.data.remote.service.comments

import com.example.jsonplaceholderwithcompose.data.remote.dto.comment.CommentsResponse

interface CommentService {

    suspend fun getComments(): List<CommentsResponse>?
}