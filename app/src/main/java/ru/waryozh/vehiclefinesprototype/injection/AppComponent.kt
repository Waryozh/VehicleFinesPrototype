package ru.waryozh.vehiclefinesprototype.injection

import dagger.Component
import ru.waryozh.vehiclefinesprototype.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PrefsModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun inject(app: App)

    fun plus(module: StartingActivityComponent.Module): StartingActivityComponent

    fun plus(module: OverviewActivityComponent.Module): OverviewActivityComponent
}
