package com.example.learneng.model.data

import com.example.dictionaryengapp.model.data.Meanings
import com.squareup.moshi.Json

class DataModel(
    @field:Json(name="text") val text: String?,
    @field:Json(name="meanings") val meanings: List<Meanings>?
)

