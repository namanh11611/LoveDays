package com.namanh.lovedays.core.di

import com.namanh.lovedays.AndroidApplication
import com.namanh.lovedays.core.di.viewmodel.ViewModelModule
import com.namanh.lovedays.core.navigation.RouteActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)
}