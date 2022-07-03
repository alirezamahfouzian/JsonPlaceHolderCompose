package com.example.jsonplaceholderwithcompose.data.remote.service.comments

import com.example.jsonplaceholderwithcompose.data.remote.dto.comment.CommentsResponse
import com.example.jsonplaceholderwithcompose.data.remote.util.HttpRoutes
import com.example.jsonplaceholderwithcompose.data.remote.util.generalResponse
import io.ktor.client.*
import io.ktor.client.request.*

class CommentsServiceImpl(
    private val client: HttpClient
) : CommentService {

    override suspend fun getComments(): List<CommentsResponse>? =
        generalResponse { client.get { url(HttpRoutes.COMMENTS_URL) } }
}
