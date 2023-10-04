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
import androidx.navigation.NavController
import com.jamirodev.retrofitgameapp.components.CardGame
import com.jamirodev.retrofitgameapp.components.MainTopBar
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_1
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_4
import com.jamirodev.retrofitgameapp.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "GAMES", onClickBackButton = {  }) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel = viewModel, pad = it, navController)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad: PaddingValues, navController: NavController) {
    val games by viewModel.games.collectAsState()
    LazyColumn(
        modifier = Modifier
            .padding(pad)
            .background(Color(COLOR_1))
    ) {
        items(games) { item ->
            CardGame(item) {
                navController.navigate("DetailView/${item.id}")
            }
            Text(text = item.name,
                fontWeight = FontWeight.ExtraBold,
                color = Color(COLOR_4),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}








