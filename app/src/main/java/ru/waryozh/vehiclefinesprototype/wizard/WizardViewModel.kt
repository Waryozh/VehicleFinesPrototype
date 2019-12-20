package ru.waryozh.vehiclefinesprototype.wizard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import ru.waryozh.vehiclefinesprototype.util.isValidRegNumber
import ru.waryozh.vehiclefinesprototype.util.isValidVehiclePassportOrLicenceNumber
import ru.waryozh.vehiclefinesprototype.util.transliterate
import javax.inject.Inject

class WizardViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _isRegNumberInvalid = MutableLiveData<Boolean>()
    val isRegNumberInvalid: LiveData<Boolean>
        get() = _isRegNumberInvalid

    private val _isPassportNumberInvalid = MutableLiveData<Boolean>()
    val isPassportNumberInvalid: LiveData<Boolean>
        get() = _isPassportNumberInvalid

    private val _isDriverLicenceInvalid = MutableLiveData<Boolean>()
    val isDriverLicenceInvalid: LiveData<Boolean>
        get() = _isDriverLicenceInvalid

    fun setRegNumber(regNumber: String) = repository.setRegNumber(regNumber.transliterate())

    fun setPassportNumber(passportNumber: String) = repository.setPassportNumber(passportNumber.transliterate())

    fun setDriverLicence(driverLicence: String) = repository.setDriverLicence(driverLicence.transliterate())

    fun onRegNumberChanged(regNumber: String) {
        _isRegNumberInvalid.value = !regNumber.isValidRegNumber()
    }

    fun onPassportNumberChanged(passportNumber: String) {
        _isPassportNumberInvalid.value = !passportNumber.isValidVehiclePassportOrLicenceNumber()
    }

    fun onDriverLicenceChanged(driverLicence: String) {
        _isDriverLicenceInvalid.value = !driverLicence.isValidVehiclePassportOrLicenceNumber()
    }
}
