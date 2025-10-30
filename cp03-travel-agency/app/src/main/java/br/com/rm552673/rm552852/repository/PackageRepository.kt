package br.com.rm552673.rm552852.repository

import br.com.rm552673.rm552852.R
import br.com.rm552673.rm552852.model.ServicesTravel

val AzulEconomic =  ServicesTravel("Azul Econômica", "Viagem de classe econômica", 400.0, R.drawable.ic_travel_economic)
val AzulExecutive = ServicesTravel("Azul Executiva", "Viagem de classe executiva", 474.0, R.drawable.ic_travel_executive)
val AzulFirstClass = ServicesTravel("Azul Primeira Classe", "Viagem de primeira classe", 474.0, R.drawable.ic_travel_first_class)

fun getAllServices(): List<ServicesTravel> {
    return listOf(
        AzulEconomic,
        AzulExecutive,
        AzulFirstClass
    )
}