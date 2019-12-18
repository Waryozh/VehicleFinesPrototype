package ru.waryozh.vehiclefinesprototype.injection

import dagger.Module
import dagger.Provides
import ru.waryozh.vehiclefinesprototype.App
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule(private val app: App) {
    @Provides
    @Singleton
    fun provideApp(): App = app
}
