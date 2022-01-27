package com.example.learneng.di

import com.example.learneng.framework.ui.search_fragment.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}