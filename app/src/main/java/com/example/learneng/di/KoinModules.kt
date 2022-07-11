package com.example.learneng.di

import androidx.room.Room
import com.example.learneng.framework.ui.description_fragment.viewModel.DescriptionViewModel
import com.example.learneng.framework.ui.history_fragment.viewModel.HistoryViewModel
import com.example.learneng.framework.ui.search_fragment.viewModel.SearchViewModel
import com.example.learneng.interactors.*
import com.example.learneng.model.datasource.DataSource
import com.example.learneng.model.datasource.DataSourceLocal
import com.example.learneng.model.datasource.DataSourceLocalImpl
import com.example.learneng.model.datasource.RetrofitImplementation
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.IRepositoryLocal
import com.example.learneng.model.repository.RepositoryImpl
import com.example.learneng.model.repository.RepositoryLocalImpl
import com.example.learneng.room.AppDb
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module


var application = module {
    single { Room.databaseBuilder(get(), AppDb::class.java, "AppDB").build() }
    // Получаем DAO
    single { get<AppDb>().historyDao() }


    single<IRepository>(named(NAME_REMOTE)) {
        RepositoryImpl(
            get(
                qualifier = named(
                    NAME_DATASOURCE_REMOTE
                )
            )
        )
    }
    single<IRepositoryLocal>(named(NAME_LOCAL)) {
        RepositoryLocalImpl(
            get(
                qualifier = named(NAME_DATASOURCE_LOCAL)
            )
        )
    }
    single<DataSource>(named(NAME_DATASOURCE_REMOTE)) { RetrofitImplementation() }
    single<DataSourceLocal>(named(NAME_DATASOURCE_LOCAL)) { DataSourceLocalImpl(get()) }
}

var searchScreen = module {
    factory { MainInteractorImpl(repo = get(qualifier = named(NAME_REMOTE)),
        repoLocal = get(qualifier = named(NAME_LOCAL))) }
    viewModel {
        SearchViewModel(get())
    }
}

var descriptionScreen = module {
    factory<IDescriptionInteractor> { DescriptionInteractor(repo = get(qualifier = named(NAME_LOCAL))) }
    viewModel {
        DescriptionViewModel(get())
    }
}
val historyScreen = module {

    viewModel {
        HistoryViewModel(get())
    }
    factory<IHistoryInteractor> { HistoryInteractorImpl(get(
        named(NAME_LOCAL)
    )) }
}