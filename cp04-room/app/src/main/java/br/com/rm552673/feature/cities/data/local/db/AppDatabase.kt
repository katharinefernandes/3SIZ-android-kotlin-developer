package br.com.rm552673.feature.cities.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.rm552673.feature.cities.data.local.dao.CityDao
import br.com.rm552673.feature.cities.data.local.entity.City

@Database(
    entities = [City::class], version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}