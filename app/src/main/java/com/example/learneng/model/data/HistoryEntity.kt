package com.example.learneng.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["word"], unique = true)])
data class HistoryEntity(
    @field:PrimaryKey
    var id : Int,
    var imageUrl : String?,
    var word : String?,
    var translation : String?,
    var transcription : String?,
    var soundUrl : String? = null
)