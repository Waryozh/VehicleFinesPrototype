package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.walkthrough.WalkthroughActivity

@Subcomponent(modules = [WalkthroughActivityComponent.Module::class])
interface WalkthroughActivityComponent {
    fun inject(activity: WalkthroughActivity)

    @dagger.Module
    class Module
}
