package br.com.katharine.viacepapp.core.ui

// classe selada
// Funciona como um enum, mas com objetos customizados dentro dela
sealed class UiState<out T> {

    data object Initial : UiState<Nothing>()

    data object Loading : UiState<Nothing>()

    data class Success<T>(
        val data: T
    ) : UiState<T>()

    data class Error(
        val message: String
    ) : UiState<Nothing>()
}