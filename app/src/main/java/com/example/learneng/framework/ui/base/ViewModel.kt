package com.example.learneng.framework.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learneng.model.data.AppState

abstract class BaseViewModel<T : AppState>(
    val liveDataToObserve: MutableLiveData<T> = MutableLiveData(),
) : ViewModel() {

    abstract fun getData(word: String, isOnline: Boolean)
    abstract fun getData(id: Int)
}