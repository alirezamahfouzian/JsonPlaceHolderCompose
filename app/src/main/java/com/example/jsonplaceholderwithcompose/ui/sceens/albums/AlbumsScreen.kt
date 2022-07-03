package com.example.jsonplaceholderwithcompose.ui.sceens.albums

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
import com.example.jsonplaceholderwithcompose.data.remote.dto.album.AlbumsResponse
import com.example.jsonplaceholderwithcompose.ui.components.GlobalLazyColumn

@Composable
fun AlbumsScreen(albumsViewModel: AlbumsViewModel) {
    AlbumsList(albumsViewModel)
}

@Composable
fun AlbumsList(albumsViewModel: AlbumsViewModel) {
    val albums = produceState<List<AlbumsResponse>>(
        initialValue = emptyList(),
        producer = { value = albumsViewModel.getAlbums() }
    )
    val listState: LazyListState = rememberLazyListState()
    GlobalLazyColumn(list = albums.value, state = listState) {
        Text(text = it.userId.toString(), fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = it.title, fontSize = 14.sp)
    }
}
