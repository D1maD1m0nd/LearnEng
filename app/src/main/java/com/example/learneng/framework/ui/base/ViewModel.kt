package com.example.learneng.framework.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learneng.framework.rx.SchedulerProvider
import com.example.learneng.model.data.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    val liveDataToObserve : MutableLiveData<T> = MutableLiveData(),
    val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel(){
    open fun getData(word : String, isOnline : Boolean) : LiveData<T> = liveDataToObserve

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}