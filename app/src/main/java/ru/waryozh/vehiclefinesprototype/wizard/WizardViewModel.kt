package ru.waryozh.vehiclefinesprototype.wizard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import ru.waryozh.vehiclefinesprototype.util.isValidRegNumber
import ru.waryozh.vehiclefinesprototype.util.transliterate
import javax.inject.Inject

class WizardViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _isRegNumberInvalid = MutableLiveData<Boolean>()
    val isRegNumberInvalid: LiveData<Boolean>
        get() = _isRegNumberInvalid

    fun setRegNumber(regNumber: String) = repository.setRegNumber(regNumber.transliterate())

    fun setPassportNumber(passportNumber: String) = repository.setPassportNumber(passportNumber)

    fun setDriverLicence(driverLicence: String) = repository.setDriverLicence(driverLicence)

    fun onRegNumberChanged(regNumber: String) {
        _isRegNumberInvalid.value = !regNumber.isValidRegNumber()
    }
}
