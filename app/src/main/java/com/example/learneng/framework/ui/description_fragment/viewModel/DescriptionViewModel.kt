package com.example.learneng.framework.ui.description_fragment.viewModel

import androidx.lifecycle.viewModelScope
import com.example.learneng.framework.ui.base.BaseViewModel
import com.example.learneng.interactors.IDescriptionInteractor
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.AppState
import kotlinx.coroutines.launch

class DescriptionViewModel(private val interactor: IDescriptionInteractor) : BaseViewModel<AppState>() {
    override fun getData(word: String, isOnline: Boolean) {
    }

    override fun getData(id: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                interactor.getData(id)
            }.onSuccess {
                liveDataToObserve.postValue(it)
            }.onFailure {
                liveDataToObserve.postValue(AppState.Error(it))
            }
        }
    }


}