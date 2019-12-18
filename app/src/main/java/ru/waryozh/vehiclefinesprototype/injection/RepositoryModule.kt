package ru.waryozh.vehiclefinesprototype.injection

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.waryozh.vehiclefinesprototype.repositories.Repository
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(prefs: SharedPreferences): Repository {
        return Repository(prefs)
    }
}
