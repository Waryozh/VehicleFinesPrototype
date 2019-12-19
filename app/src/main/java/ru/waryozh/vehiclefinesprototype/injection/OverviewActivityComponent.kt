package ru.waryozh.vehiclefinesprototype.injection

import dagger.Subcomponent
import ru.waryozh.vehiclefinesprototype.overview.OverviewActivity

@Subcomponent(modules = [OverviewActivityComponent.Module::class])
interface OverviewActivityComponent {
    fun inject(activity: OverviewActivity)

    @dagger.Module
    class Module
}
