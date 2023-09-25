package com.jamirodev.retrofitgameapp.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.jamirodev.retrofitgameapp.viewModel.GamesViewModel

@Composable
fun DetailView(viewModel: GamesViewModel, navController: NavController, id: Int) {
    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }
    Text(text = viewModel.state.name, color = Color.Black)
}