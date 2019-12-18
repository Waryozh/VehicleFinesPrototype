package ru.waryozh.vehiclefinesprototype.injection

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ru.waryozh.vehiclefinesprototype.App
import javax.inject.Singleton

@Module
class PrefsModule {
    @Provides
    @Singleton
    fun providePrefs(application: App): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}
