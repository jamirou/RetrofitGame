package com.jamirodev.retrofitgameapp.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jamirodev.retrofitgameapp.components.MainTopBar
import com.jamirodev.retrofitgameapp.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel) {
    Scaffold(
        topBar = {
            MainTopBar(title = "GAMES") {}
        }
    ) {
        ContentHomeView(viewModel = viewModel, pad = it)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad: PaddingValues) {
    val games by viewModel.games.collectAsState()
    LazyColumn(modifier = Modifier.padding(pad)) {
        items(games) { item ->
            Text(text = item.background_image)

        }
    }
}








