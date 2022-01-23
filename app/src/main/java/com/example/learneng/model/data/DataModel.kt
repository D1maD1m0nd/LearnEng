package com.example.dictionaryengapp.model.data

import com.squareup.moshi.Json

class DataModel(
    @field:Json(name="text") val text: String?,
    @field:Json(name="meanings") val meanings: List<Meanings>?
)

