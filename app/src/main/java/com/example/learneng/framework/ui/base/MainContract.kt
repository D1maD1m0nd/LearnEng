package com.example.learneng.framework.ui.base

import com.example.learneng.model.data.AppState

class MainContract {
    interface View {
        fun setState(state : AppState)
    }
    interface Presenter {
        fun attachView(v : View)
        fun detachView(v : View)
    }
}