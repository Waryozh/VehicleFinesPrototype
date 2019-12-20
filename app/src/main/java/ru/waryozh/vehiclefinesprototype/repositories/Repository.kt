package ru.waryozh.vehiclefinesprototype.repositories

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        private const val SHOULD_SHOW_WALKTHROUGH = "SHOULD_SHOW_WALKTHROUGH"
        private const val SHOULD_SHOW_OVERVIEW = "SHOULD_SHOW_OVERVIEW"

        private const val REG_NUMBER = "REG_NUMBER"
        private const val PASSPORT_NUMBER = "PASSPORT_NUMBER"
        private const val DRIVER_LICENCE = "DRIVER_LICENCE"
    }

    fun getShouldShowWalkthrough() = prefs.getBoolean(SHOULD_SHOW_WALKTHROUGH, false)

    fun setShouldShowWalkthrough(shouldShowWalkthrough: Boolean) {
        prefs.edit {
            putBoolean(SHOULD_SHOW_WALKTHROUGH, shouldShowWalkthrough)
        }
    }

    fun getShouldShowOverview() = prefs.getBoolean(SHOULD_SHOW_OVERVIEW, false)

    fun setShouldShowOverview(shouldShowOverview: Boolean) {
        prefs.edit {
            putBoolean(SHOULD_SHOW_OVERVIEW, shouldShowOverview)
        }
    }

    fun getRegNumber() = prefs.getString(REG_NUMBER, null)

    fun setRegNumber(regNumber: String) {
        prefs.edit {
            putString(REG_NUMBER, regNumber)
        }
    }

    fun getPassportNumber() = prefs.getString(PASSPORT_NUMBER, null)

    fun setPassportNumber(passportNumber: String) {
        prefs.edit {
            putString(PASSPORT_NUMBER, passportNumber)
        }
    }

    fun getDriverLicence() = prefs.getString(DRIVER_LICENCE, null)

    fun setDriverLicence(driverLicence: String) {
        prefs.edit {
            putString(DRIVER_LICENCE, driverLicence)
        }
    }
}
