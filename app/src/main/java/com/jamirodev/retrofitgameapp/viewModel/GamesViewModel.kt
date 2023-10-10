package com.jamirodev.retrofitgameapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.jamirodev.retrofitgameapp.data.GamesDataSource
import com.jamirodev.retrofitgameapp.model.GameList
import com.jamirodev.retrofitgameapp.repository.GamesRepository
import com.jamirodev.retrofitgameapp.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    var state by mutableStateOf(GameState())
        private set

    init {
        fetchGames()
    }

    val gamesPage = Pager(PagingConfig(pageSize = 3)) {
        GamesDataSource(repository)
    }.flow.cachedIn(viewModelScope)

    private fun fetchGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGames()
                _games.value = result ?: emptyList()
            }
        }
    }

    fun getGameById(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGameById(id)
                state = state.copy(
                    name = result?.name ?: "",
                    description_raw = result?.description_raw ?: "",
                    metacritic = result?.metacritic ?: 666,
                    website = result?.website ?: "no web",
                    background_image = result?.background_image ?: "",
                )
            }
        }
    }    fun getGameByName(name: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGameByName(name)
                state = state.copy(
                    name = result?.name ?: "",
                    description_raw = result?.description_raw ?: "",
                    metacritic = result?.metacritic ?: 666,
                    website = result?.website ?: "no web",
                    background_image = result?.background_image ?: "",
                )
            }
        }
    }

    fun clean() {
        state = state.copy(
            name =  "",
            description_raw =  "",
            metacritic = 666,
            website = "",
            background_image =  "",
        )
    }

}





