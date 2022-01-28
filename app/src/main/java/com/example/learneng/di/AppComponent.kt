package com.example.learneng.di

import android.app.Application
import com.example.learneng.App.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        FragmentModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        AppModule::class
        ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}