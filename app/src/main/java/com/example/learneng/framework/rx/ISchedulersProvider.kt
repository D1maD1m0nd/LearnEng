package com.example.learneng.framework.rx

import io.reactivex.rxjava3.core.Scheduler


interface ISchedulerProvider {

    val ui: Scheduler
    val io: Scheduler
}
