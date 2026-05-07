package br.com.katharine.dragonball.presentation.dragonball.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterSearchViewModel : ViewModel() {

    private val _characterId = MutableStateFlow("")
    val characterId: StateFlow<String> = _characterId

    fun onCharacterIdChanged(value: String) {
        _characterId.value = value.filter { it.isDigit() }
    }

    fun getCharacterIdOrNull(): Int? {
        return _characterId.value.toIntOrNull()
    }
}