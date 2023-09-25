package com.jamirodev.retrofitgameapp.views

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jamirodev.retrofitgameapp.components.CardGame
import com.jamirodev.retrofitgameapp.components.MainTopBar
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_1
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_2
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_3
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_4
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_5
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
    LazyColumn(
        modifier = Modifier.padding(pad)
            .background(Color(COLOR_1))
    ) {
        items(games) { item ->
            CardGame(item) {
                ///next view
            }
            Text(text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color(COLOR_4),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}








