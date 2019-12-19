package ru.waryozh.vehiclefinesprototype.overview

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class OverviewViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getRegNumber() = repository.getRegNumber()

    fun getPassportNumber() = repository.getPassportNumber()

    fun getDriverLicence() = repository.getDriverLicence()
}
