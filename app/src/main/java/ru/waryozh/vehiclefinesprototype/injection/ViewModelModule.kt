package ru.waryozh.vehiclefinesprototype.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.waryozh.vehiclefinesprototype.start.StartingViewModel
import ru.waryozh.vehiclefinesprototype.viewmodels.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StartingViewModel::class)
    abstract fun bindStartingViewModel(startingViewModel: StartingViewModel): ViewModel
}
