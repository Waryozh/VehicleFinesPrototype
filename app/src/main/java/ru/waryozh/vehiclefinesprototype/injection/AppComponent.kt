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

    fun plus(module: WizardRegNumberFragmentComponent.Module): WizardRegNumberFragmentComponent

    fun plus(module: WizardPassportNumberFragmentComponent.Module): WizardPassportNumberFragmentComponent

    fun plus(module: WizardDriverLicenceFragmentComponent.Module): WizardDriverLicenceFragmentComponent

    fun plus(module: WalkthroughActivityComponent.Module): WalkthroughActivityComponent

    fun plus(module: OverviewActivityComponent.Module): OverviewActivityComponent
}
