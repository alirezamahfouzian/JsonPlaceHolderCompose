package com.example.jsonplaceholderwithcompose.data.remote.service.album

import com.example.jsonplaceholderwithcompose.data.remote.dto.album.AlbumsResponse
import com.example.jsonplaceholderwithcompose.data.remote.util.HttpRoutes
import com.example.jsonplaceholderwithcompose.data.remote.util.generalResponse
import io.ktor.client.*
import io.ktor.client.request.*

class AlbumsServiceImpl(
    private val client: HttpClient
) : AlbumsService {

    override suspend fun getAlbums(): List<AlbumsResponse>? =
        generalResponse {
            client.get {
                url(HttpRoutes.ALBUM_URL)
            }
        }
}
