package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.start.StartingActivity

@Subcomponent(modules = [StartingActivityComponent.Module::class])
interface StartingActivityComponent {
    fun inject(activity: StartingActivity)

    @dagger.Module
    class Module
}
