package ru.waryozh.vehiclefinesprototype.wizard

import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Inject

class WizardViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun setRegNumber(regNumber: String) = repository.setRegNumber(regNumber)

    fun setPassportNumber(passportNumber: String) = repository.setPassportNumber(passportNumber)

    fun setDriverLicence(driverLicence: String) = repository.setDriverLicence(driverLicence)
}
