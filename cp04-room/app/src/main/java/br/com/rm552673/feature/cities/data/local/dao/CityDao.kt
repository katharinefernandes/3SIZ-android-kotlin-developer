package br.com.rm552673.feature.cities.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.rm552673.feature.cities.data.local.entity.City
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert
    suspend fun insert(city: City)

    @Update
    suspend fun update(city: City)

    @Delete
    suspend fun delete(city: City)

    // removi a ordenação por isVisited e mantive apenas a do ID
    @Query("SELECT * FROM cities ORDER BY id DESC")
    fun getAll(): Flow<List<City>>

    @Query("DELETE FROM cities")
    suspend fun clearAll()

    @Query(
        "UPDATE cities SET isVisited = :isVisited WHERE id =:cityId"
    )
    suspend fun updateCityStatus(cityId: Int, isVisited: Boolean)
}