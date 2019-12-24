package ru.waryozh.vehiclefinesprototype.walkthrough

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class WalkthroughViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var shouldShowWalkthrough
        get() = repository.shouldShowWalkthrough
        set(value) {
            repository.shouldShowWalkthrough = value
        }
}
