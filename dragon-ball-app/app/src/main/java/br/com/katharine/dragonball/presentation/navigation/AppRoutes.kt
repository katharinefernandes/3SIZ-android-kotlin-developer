package br.com.katharine.dragonball.presentation.navigation

object AppRoutes {
    const val CHARACTER_LIST = "character_list"
    const val CHARACTER_SEARCH = "character_search"
    const val CHARACTER_DETAIL = "character/{id}"

    fun characterDetail(characterId: Int): String {
        return "character/$characterId"
    }
}