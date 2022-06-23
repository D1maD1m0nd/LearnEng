package com.example.learneng.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learneng.model.data.HistoryEntity

@Dao
interface HistoryDao {
    @Query("SELECT * FROM HistoryEntity")
    suspend fun all(): List<HistoryEntity>

    @Query("SELECT * FROM HistoryEntity WHERE id = :id")
    suspend fun getWordById(id : Int) : HistoryEntity

    @Query("SELECT * FROM HistoryEntity WHERE word LIKE '%' || :word || '%'")
    suspend fun getHistoryByWord(word : String) : HistoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(historyEntity: List<HistoryEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(historyEntity: HistoryEntity )
}