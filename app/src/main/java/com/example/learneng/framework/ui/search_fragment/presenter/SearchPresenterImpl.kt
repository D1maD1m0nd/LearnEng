package com.example.learneng.framework.ui.search_fragment.presenter

import com.example.dictionaryengapp.interactors.IMainInteractor
import com.example.learneng.interactors.MainInteractorImpl
import com.example.dictionaryengapp.model.data.AppState
import com.example.learneng.framework.rx.ISchedulerProvider
import com.example.learneng.framework.rx.SchedulerProvider
import com.example.learneng.framework.ui.base.MainContract
import com.example.learneng.model.datasource.DataSource
import com.example.learneng.model.datasource.DataSourceRemoteImpl
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.RepositoryImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SearchPresenterImpl: SearchPresenter{

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val schedulerProvider: ISchedulerProvider = SchedulerProvider()
    private val dataSourceRemote : DataSource = DataSourceRemoteImpl()
    private val repository : IRepository = RepositoryImpl(dataSourceRemote)
    private val interactor : IMainInteractor = MainInteractorImpl(repository)
    private var view : MainContract.View? = null

    override fun attachView(v: MainContract.View) {
        if(v != view) {
            view = v
        }
    }

    override fun detachView(v: MainContract.View) {
        compositeDisposable.dispose()
        view = null
    }

    override fun search(word: String) {
        interactor.getData(word)
            .observeOn(schedulerProvider.io)
            .subscribeOn(schedulerProvider.ui)
            .doOnSubscribe {
                view?.setState(AppState.Loading(null))
            }
            .subscribe(
                {view?.setState(AppState.Success(it))},
                {view?.setState(AppState.Error(it))})
    }

}