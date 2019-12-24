package ru.waryozh.vehiclefinesprototype.overview

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class OverviewViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    val regNumber = repository.regNumber

    val passportNumber = repository.passportNumber

    val driverLicence = repository.driverLicence

    var shouldShowOverview
        get() = repository.shouldShowOverview
        set(value) {
            repository.shouldShowOverview = value
        }
}
