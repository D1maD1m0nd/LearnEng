package com.example.learneng.framework.ui.search_fragment.presenter

import com.example.dictionaryengapp.model.data.AppState
import com.example.learneng.framework.rx.ISchedulerProvider
import com.example.learneng.framework.rx.SchedulerProvider
import com.example.learneng.framework.ui.base.MainContract
import io.reactivex.disposables.CompositeDisposable

class SearchPresenterImpl<T : AppState, V : MainContract.View> : SearchPresenter<T, V> {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val schedulerProvider: ISchedulerProvider = SchedulerProvider()
    private var view : V? = null

    override fun attachView(v: V) {
        if(v != view) {
            view = v
        }
    }

    override fun detachView(v: V) {
        compositeDisposable.dispose()
        view = null
    }

    override fun search(word: String) {
        TODO("Not yet implemented")
    }

}