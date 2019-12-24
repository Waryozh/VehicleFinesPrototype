package ru.waryozh.vehiclefinesprototype.start

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class StartingViewModel @Inject constructor(repository: Repository) : ViewModel() {
    val shouldShowWalkthrough = repository.shouldShowWalkthrough

    val shouldShowOverview = repository.shouldShowOverview
}
