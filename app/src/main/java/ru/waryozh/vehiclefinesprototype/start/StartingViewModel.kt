package ru.waryozh.vehiclefinesprototype.start

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class StartingViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getShouldShowWalkthrough() = repository.getShouldShowWalkthrough()

    fun getShouldShowOverview() = repository.getShouldShowOverview()
}
