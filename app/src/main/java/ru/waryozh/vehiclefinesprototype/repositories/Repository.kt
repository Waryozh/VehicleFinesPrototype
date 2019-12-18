package ru.waryozh.vehiclefinesprototype.repositories

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        private const val SHOULD_SHOW_WELCOME = "SHOULD_SHOW_WELCOME"
    }

    fun getShouldShowWelcome() = prefs.getBoolean(SHOULD_SHOW_WELCOME, true)

    fun setShouldShowWelcome(shouldShowWelcome: Boolean) {
        prefs.edit {
            putBoolean(SHOULD_SHOW_WELCOME, shouldShowWelcome)
        }
    }
}
