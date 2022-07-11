package com.example.learneng.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learneng.model.data.HistoryEntity


@Database(entities = [HistoryEntity::class],
    version = 1,
    exportSchema = true,
    autoMigrations = [])
abstract  class AppDb : RoomDatabase(){
    // Возвращаем DAO
    abstract fun historyDao(): HistoryDao
}