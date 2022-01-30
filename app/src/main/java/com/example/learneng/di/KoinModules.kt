package com.example.learneng.di

import com.example.learneng.framework.ui.search_fragment.viewModel.SearchViewModel
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.datasource.DataSource
import com.example.learneng.model.datasource.RetrofitImplementation
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


var application = module {
    single<IRepository>(named(NAME_REMOTE)) { RepositoryImpl(get(qualifier = named(NAME_DATASOURCE_REMOTE))) }

    single<DataSource>(named(NAME_DATASOURCE_REMOTE)) { RetrofitImplementation() }
}

var searchScreen = module {
    factory { MainInteractorImpl(repo = get(qualifier = named(NAME_REMOTE))) }

    viewModel {
        SearchViewModel(get())
    }

}