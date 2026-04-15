package br.com.rm552673.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm552673.feature.cities.data.local.entity.City
import br.com.rm552673.feature.cities.data.local.repository.CityRepository
import kotlinx.coroutines.launch

class CityViewModel(
    private val repository: CityRepository
) : ViewModel() {

    val cities = repository.cities

    fun addCity(name: String, description: String) {
        viewModelScope.launch {
            repository.insert(City(name = name, description = description))
        }
    }

    fun onCityChecked(city: City, checked: Boolean) {
        viewModelScope.launch {
            repository.updateCityStatus(
                cityId = city.id,
                isVisited = checked
            )
        }
    }

    fun removeCity(city: City) {
        viewModelScope.launch {
            repository.delete(city)
        }
    }

    fun clearAllCities() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}