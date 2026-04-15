package br.com.rm552673.feature.cities.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val isVisited: Boolean = false,
    val name: String,
    val description: String
)