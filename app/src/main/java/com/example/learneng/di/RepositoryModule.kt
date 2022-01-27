package com.example.learneng.di

import com.example.learneng.model.data.DataModel
import com.example.learneng.model.datasource.DataSource
import com.example.learneng.model.datasource.RetrofitImplementation
import com.example.learneng.model.repository.IRepository
import com.example.learneng.model.repository.RepositoryImpl


import dagger.Module
import dagger.Provides


import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource): IRepository =
        RepositoryImpl(dataSourceRemote)



    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource =
        RetrofitImplementation()


}
