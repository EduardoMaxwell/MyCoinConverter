package br.com.eduardomaxwell.mycoinconverter.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.dio.coinconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeDao {

    @Query("Select * from tb_exchange")
    fun findAll(): Flow<List<ExchangeResponseValue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(entity: ExchangeResponseValue)
}