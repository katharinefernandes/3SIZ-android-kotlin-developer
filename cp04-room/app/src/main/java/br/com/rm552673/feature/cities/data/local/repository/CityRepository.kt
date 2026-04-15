package br.com.rm552673.feature.cities.data.local.repository

import br.com.rm552673.feature.cities.data.local.dao.CityDao
import br.com.rm552673.feature.cities.data.local.entity.City

class CityRepository(
    private val dao: CityDao
) {
    val cities = dao.getAll()
    suspend fun insert(city: City) {
        dao.insert(city)
    }

    suspend fun updateCityStatus(
        cityId: Int, isVisited: Boolean
    ) {
        dao.updateCityStatus(cityId, isVisited)
    }

    suspend fun delete(city: City) {
        dao.delete(city)
    }

    suspend fun clearAll() {
        dao.clearAll()
    }
}