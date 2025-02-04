package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.wizard.fragments.WizardRegNumberFragment

@Subcomponent(modules = [WizardRegNumberFragmentComponent.Module::class])
interface WizardRegNumberFragmentComponent {
    fun inject(fragment: WizardRegNumberFragment)

    @dagger.Module
    class Module
}
