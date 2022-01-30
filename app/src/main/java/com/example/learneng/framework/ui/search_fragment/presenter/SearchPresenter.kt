package com.example.learneng.framework.ui.search_fragment.presenter

import com.example.learneng.framework.ui.base.MainContract



interface SearchPresenter : MainContract.Presenter{
    fun search(word : String)
}
