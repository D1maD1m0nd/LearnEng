package com.example.learneng.utils

import com.example.learneng.model.data.*
import kotlin.random.Random


fun AppState.convertToHistoryEntity() : List<HistoryEntity>? =
    when(this) {
        is AppState.Success -> {
            val searchResult = this.data
            if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty()) {
                null
            } else {
                searchResult.map {
                    val id = it.id
                    val imageUrl = it.meanings?.firstOrNull()?.imageUrl
                    val word = it.text
                    val translation = it.meanings?.firstOrNull()?.translation?.translation
                    val transcription = it.meanings?.firstOrNull()?.transcription
                    HistoryEntity(id, imageUrl, word, translation, transcription)
                }
            }
        }
        else -> null
    }

fun HistoryEntity.convertToDataModel() : DataModel{

    val list = listOf(Meanings(Random.nextInt(), Translation(this.translation), this.imageUrl, this.transcription, this.soundUrl))
    return DataModel(this.id, text = this.word, list)
}