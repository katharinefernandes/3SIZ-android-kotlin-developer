package com.example.cp_modelo_b.data

import com.example.cp_modelo_b.R

data class Characteristic(
    val name: String = "",
    val imageHouseSymbRes: Int = R.drawable.house_martell_symb,
    val imageHouseRes: Int = R.drawable.house_martell
)

val starters = listOf(
    Characteristic("Coragem", R.drawable.house_stark_symb, R.drawable.house_stark),
    Characteristic("Inteligência", R.drawable.house_lannister_symb, R.drawable.house_lannister),
    Characteristic("Lealdade", R.drawable.house_greyjoy_symb, R.drawable.house_grejoy),
    Characteristic("Ambição", R.drawable.house_targaryan_symb, R.drawable.house_targaryen)
)