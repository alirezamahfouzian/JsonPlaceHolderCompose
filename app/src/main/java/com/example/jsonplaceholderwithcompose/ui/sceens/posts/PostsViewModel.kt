package com.example.jsonplaceholderwithcompose.ui.sceens.posts

import androidx.lifecycle.ViewModel
import com.example.jsonplaceholderwithcompose.data.remote.dto.posts.PostsResponse
import com.example.jsonplaceholderwithcompose.data.remote.service.posts.PostsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val postsService: PostsService) : ViewModel() {

    private var postList = emptyList<PostsResponse>()

    suspend fun getPostList(): List<PostsResponse> {
        if (postList.isEmpty()) {
            postsService.getPosts()?.also {
                postList = it
            }
        }
        return postList
    }
}