package com.example.learneng.framework.ui.description_fragment.viewModel

import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState

class DescriptionViewModel(private val interactor: MainInteractorImpl) : BaseViewModel<AppState>() {
    override fun getData(word: String, isOnline: Boolean) {
        TODO("Not yet implemented")
    }
}