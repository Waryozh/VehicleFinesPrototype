package ru.waryozh.vehiclefinesprototype.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.waryozh.vehiclefinesprototype.overview.OverviewViewModel
import ru.waryozh.vehiclefinesprototype.start.StartingViewModel
import ru.waryozh.vehiclefinesprototype.viewmodels.ViewModelFactory
import ru.waryozh.vehiclefinesprototype.walkthrough.WalkthroughViewModel
import ru.waryozh.vehiclefinesprototype.wizard.WizardViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StartingViewModel::class)
    abstract fun bindStartingViewModel(viewModel: StartingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WizardViewModel::class)
    abstract fun bindWizardViewModel(viewModel: WizardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WalkthroughViewModel::class)
    abstract fun bindWalkthroughViewModel(viewModel: WalkthroughViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OverviewViewModel::class)
    abstract fun bindOverviewViewModel(viewModel: OverviewViewModel): ViewModel
}
