package br.com.katharine.viacepapp.ui.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.katharine.viacepapp.core.ui.UiState
import br.com.katharine.viacepapp.model.CepResponse
import br.com.katharine.viacepapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class SearchCepViewModel : ViewModel() {

    // get publico, mas set é privado
    var cep by mutableStateOf("")
        private set

    // apenas a ViewModel pode ter acesso para realizar a alteração. Por tanto, o set fica privado
    // ao indicar o <> Generics, o uiState fica identificado como UiState
    var uiState by mutableStateOf<UiState<CepResponse>>(UiState.Initial)
        private set

    // irá atualizar o cep
    fun onCepChange(newValue: String) {
        // filtra por apenas números e pega os primeiros 8 digitos
        cep = newValue.filter { it.isDigit() }.take(8)

        if (uiState is UiState.Error) {
            uiState = UiState.Initial
        }
    }

    fun searchCep() {
        uiState = UiState.Loading
        val cepClear = cep.filter { it.isDigit() }

        if (cepClear.length != 8) {
            uiState = UiState.Error("CEP Inválido")
            return
        }

        // chamada assíncrona, não carrega na thread principal da tela e não faz ela ficar travada na tela
        // coroutines, faz funcionar de forma assíncrona algo que é síncrono
        // A chamada contínua síncrona, porém com co-routines, ele transforma a chamada em assíncrona
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.viaCepApi.buscarCep(cepClear)
                uiState = UiState.Success(response)
            } catch (e: Exception) {
                uiState = UiState.Error("Erro ao buscar o cep")
            }
        }
    }

}