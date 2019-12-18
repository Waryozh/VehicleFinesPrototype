package ru.waryozh.vehiclefinesprototype

import android.app.Application
import ru.waryozh.vehiclefinesprototype.injection.AppComponent
import ru.waryozh.vehiclefinesprototype.injection.AppModule
import ru.waryozh.vehiclefinesprototype.injection.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)
    }
}
