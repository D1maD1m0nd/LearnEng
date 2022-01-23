package com.example.learneng.framework.ui.base

import com.example.dictionaryengapp.model.data.AppState

class MainContract {
    interface View {
        fun setState(state : AppState)
    }

    interface Presenter<T : AppState, V : View> {
        fun attachView(v : V)
        fun detachView(v : V)
    }
}