package com.example.jsonplaceholderwithcompose.ui.sceens.albums

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jsonplaceholderwithcompose.data.remote.dto.album.AlbumsResponse
import com.example.jsonplaceholderwithcompose.data.remote.service.album.AlbumsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val postsService: AlbumsService) : ViewModel() {

    private var albumsList by mutableStateOf(emptyList<AlbumsResponse>())

    suspend fun getAlbums(): List<AlbumsResponse> {
        if (albumsList.isEmpty()) {
            postsService.getAlbums()?.also {
                albumsList = it
            }
        }
        return albumsList
    }
}