package ru.waryozh.vehiclefinesprototype.repositories

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        private const val SHOULD_SHOW_WELCOME = "SHOULD_SHOW_WELCOME"
        private const val REG_NUMBER = "REG_NUMBER"
        private const val PASSPORT_NUMBER = "PASSPORT_NUMBER"
        private const val DRIVER_LICENCE = "DRIVER_LICENCE"
    }

    fun getShouldShowWelcome() = prefs.getBoolean(SHOULD_SHOW_WELCOME, true)

    fun setShouldShowWelcome(shouldShowWelcome: Boolean) {
        prefs.edit {
            putBoolean(SHOULD_SHOW_WELCOME, shouldShowWelcome)
        }
    }

    fun getRegNumber() = prefs.getString(REG_NUMBER, "")

    fun setRegNumber(regNumber: String) {
        prefs.edit {
            putString(REG_NUMBER, regNumber)
        }
    }

    fun getPassportNumber() = prefs.getString(PASSPORT_NUMBER, "")

    fun setPassportNumber(passportNumber: String) {
        prefs.edit {
            putString(PASSPORT_NUMBER, passportNumber)
        }
    }

    fun getDriverLicence() = prefs.getString(DRIVER_LICENCE, "")

    fun setDriverLicence(driverLicence: String) {
        prefs.edit {
            putString(DRIVER_LICENCE, driverLicence)
        }
    }
}
