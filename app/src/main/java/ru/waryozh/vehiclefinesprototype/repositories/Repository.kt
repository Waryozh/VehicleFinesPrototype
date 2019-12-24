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

    var shouldShowWalkthrough: Boolean
        get() = prefs.getBoolean(SHOULD_SHOW_WALKTHROUGH, false)
        set(value) {
            prefs.edit {
                putBoolean(SHOULD_SHOW_WALKTHROUGH, value)
            }
        }

    var shouldShowOverview: Boolean
        get() = prefs.getBoolean(SHOULD_SHOW_OVERVIEW, false)
        set(value) {
            prefs.edit {
                putBoolean(SHOULD_SHOW_OVERVIEW, value)
            }
        }

    var regNumber: String?
        get() = prefs.getString(REG_NUMBER, null)
        set(value) {
            prefs.edit {
                putString(REG_NUMBER, value)
            }
        }

    var passportNumber: String?
        get() = prefs.getString(PASSPORT_NUMBER, null)
        set(value) {
            prefs.edit {
                putString(PASSPORT_NUMBER, value)
            }
        }

    var driverLicence: String?
        get() = prefs.getString(DRIVER_LICENCE, null)
        set(value) {
            prefs.edit {
                putString(DRIVER_LICENCE, value)
            }
        }
}
