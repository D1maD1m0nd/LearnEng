package com.example.learneng.di

import android.app.Application
import com.example.learneng.App.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        FragmentModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class
        ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}