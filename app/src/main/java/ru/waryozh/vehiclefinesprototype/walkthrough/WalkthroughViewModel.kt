package ru.waryozh.vehiclefinesprototype.walkthrough

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class WalkthroughViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun setShouldShowWalkthrough(shouldShowWalkthrough: Boolean) {
        repository.setShouldShowWalkthrough(shouldShowWalkthrough)
    }
}
