package com.example.dictionaryengapp.model.data

import com.example.learneng.model.data.Translation
import com.squareup.moshi.Json

class Meanings(
    @field:Json(name="translation") val translation: Translation?,
    @field:Json(name="imageUrl") val imageUrl: String?,
    @field:Json(name="transcription") val transcription : String?,
    @field:Json(name="soundUrl") val soundUrl : String?
)