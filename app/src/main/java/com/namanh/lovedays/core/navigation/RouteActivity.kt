package com.namanh.lovedays.core.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.namanh.lovedays.AndroidApplication
import com.namanh.lovedays.core.di.ApplicationComponent
import javax.inject.Inject

class RouteActivity : AppCompatActivity() {
    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    @Inject
    internal lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        navigator.showMain(this)
    }
}