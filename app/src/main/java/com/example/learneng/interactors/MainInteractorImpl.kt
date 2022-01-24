package com.example.learneng.interactors

import com.example.dictionaryengapp.interactors.IMainInteractor
import com.example.learneng.model.data.DataModel
import com.example.learneng.model.repository.IRepository
import io.reactivex.rxjava3.core.Single


class MainInteractorImpl(private val repo : IRepository) : IMainInteractor {
    override fun getData(word: String): Single<List<DataModel>> {
        return repo.getData(word)
    }
}