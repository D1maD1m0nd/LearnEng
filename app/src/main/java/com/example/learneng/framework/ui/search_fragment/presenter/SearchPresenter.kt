package com.example.learneng.framework.ui.search_fragment.presenter

import com.example.dictionaryengapp.model.data.AppState
import com.example.learneng.framework.ui.base.MainContract



interface SearchPresenter<T : AppState, V : MainContract.View> : MainContract.Presenter<T, V>{
    fun search(word : String)
}
