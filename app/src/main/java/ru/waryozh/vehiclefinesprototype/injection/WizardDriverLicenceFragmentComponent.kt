package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.wizard.fragments.WizardDriverLicenceFragment

@Subcomponent(modules = [WizardDriverLicenceFragmentComponent.Module::class])
interface WizardDriverLicenceFragmentComponent {
    fun inject(fragment: WizardDriverLicenceFragment)

    @dagger.Module
    class Module
}
