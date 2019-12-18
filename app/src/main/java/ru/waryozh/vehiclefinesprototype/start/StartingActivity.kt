package ru.waryozh.vehiclefinesprototype.start

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ru.waryozh.vehiclefinesprototype.App
import ru.waryozh.vehiclefinesprototype.R
import ru.waryozh.vehiclefinesprototype.injection.StartingActivityComponent
import ru.waryozh.vehiclefinesprototype.welcome.WelcomeActivity
import javax.inject.Inject

class StartingActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val startingViewModel: StartingViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(StartingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)

        (application as App).appComponent
            .plus(StartingActivityComponent.Module())
            .inject(this)

        // This is an artificial delay to show this activity before another one is started.
        // For use only in the prototype version of the app.
        Handler().postDelayed({
            if (startingViewModel.getShouldShowWelcome()) {
                startActivity(Intent(this, WelcomeActivity::class.java))
            }
            finish()
        }, 1000)
    }
}
