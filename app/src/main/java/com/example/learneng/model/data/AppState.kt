package com.example.learneng.model.data

sealed class AppState {

    data class Success(val data: List<DataModel>?, val entity : DataModel? = null) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}