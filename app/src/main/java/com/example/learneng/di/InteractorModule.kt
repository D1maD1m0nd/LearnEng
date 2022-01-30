package com.example.learneng.di

import com.example.learneng.interactors.IMainInteractor
import com.example.learneng.interactors.MainInteractorImpl
import com.example.learneng.model.data.DataModel
import com.example.learneng.model.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: IRepository,
    ) = MainInteractorImpl(repositoryRemote)
}
