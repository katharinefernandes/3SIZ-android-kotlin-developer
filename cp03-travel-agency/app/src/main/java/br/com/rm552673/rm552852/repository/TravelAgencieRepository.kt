package br.com.rm552673.rm552852.repository

import br.com.rm552673.rm552852.R
import br.com.rm552673.rm552852.model.TravelAgencie

fun getAllAgencies(): List<TravelAgencie> {
    return listOf(
        TravelAgencie("Gol", R.drawable.ic_travel_economic, listOf()),
        TravelAgencie("Azul", R.drawable.ic_travel_executive, listOf(AzulEconomic, AzulExecutive, AzulFirstClass))
    )
}