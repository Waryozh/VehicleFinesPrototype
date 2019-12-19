package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.wizard.fragments.WizardPassportNumberFragment

@Subcomponent(modules = [WizardPassportNumberFragmentComponent.Module::class])
interface WizardPassportNumberFragmentComponent {
    fun inject(fragment: WizardPassportNumberFragment)

    @dagger.Module
    class Module
}
