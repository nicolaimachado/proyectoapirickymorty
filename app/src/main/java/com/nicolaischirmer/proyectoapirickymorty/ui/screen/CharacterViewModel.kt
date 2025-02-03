package com.nicolaischirmer.proyectoapirickymorty.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolaischirmer.proyectoapirickymorty.api.APIClient
import com.nicolaischirmer.proyectoapirickymorty.api.Characters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characterList = MutableStateFlow<List<Characters>>(emptyList())
    val characterList: StateFlow<List<Characters>> = _characterList
    init {
        fetchCharacterList()
    }

    private fun fetchCharacterList() {
        viewModelScope.launch {
            try {
                val response = APIClient.apiService.listCharacters(1)
                _characterList.value = response.results ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}