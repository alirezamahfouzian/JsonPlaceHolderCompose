package com.example.jsonplaceholderwithcompose.data.remote.service.album

import com.example.jsonplaceholderwithcompose.data.remote.dto.album.AlbumsResponse

interface AlbumsService {

    suspend fun getAlbums(): List<AlbumsResponse>?
}