package com.jamirodev.retrofitgameapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.jamirodev.retrofitgameapp.components.CardGame
import com.jamirodev.retrofitgameapp.components.Loader
import com.jamirodev.retrofitgameapp.components.MainTopBar
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_1
import com.jamirodev.retrofitgameapp.util.Constants.Companion.COLOR_4
import com.jamirodev.retrofitgameapp.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            MainTopBar(title = "GAMES", onClickBackButton = { }) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel = viewModel, pad = it, navController)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad: PaddingValues, navController: NavController) {
    //val games by viewModel.games.collectAsState()
    val gamesPage = viewModel.gamesPage.collectAsLazyPagingItems()
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(pad),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = search,
            onValueChange = { search = it },
            label = { Text(text = "Search") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    val zero = 0
                    navController.navigate("DetailView/${zero}/?${search}")
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
        Loader()

        LazyColumn(
            modifier = Modifier
                .background(Color(COLOR_1))
        ) {
            items(gamesPage.itemCount) { index ->
                val item = gamesPage[index]
                if (item != null) {
                    CardGame(item) {
                        navController.navigate("DetailView/${item.id}/?${search}")
                    }
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(COLOR_4),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}








